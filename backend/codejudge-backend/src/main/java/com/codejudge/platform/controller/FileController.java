package com.codejudge.platform.controller;

import cn.hutool.core.io.FileUtil;
import com.codejudge.platform.common.BaseResponse;
import com.codejudge.platform.common.ErrorCode;
import com.codejudge.platform.common.ResultUtils;
import com.codejudge.platform.constant.FileConstant;
import com.codejudge.platform.exception.BusinessException;
import com.codejudge.platform.manager.CosManager;
import com.codejudge.platform.model.dto.file.UploadFileRequest;
import com.codejudge.platform.model.entity.User;
import com.codejudge.platform.model.enums.FileUploadBizEnum;
import com.codejudge.platform.service.UserService;
import java.io.File;
import java.util.Arrays;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 鏂囦欢鎺ュ彛
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Resource
    private UserService userService;

    @Resource
    private CosManager cosManager;

    /**
     * 鏂囦欢涓婁紶
     *
     * @param multipartFile
     * @param uploadFileRequest
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public BaseResponse<String> uploadFile(@RequestPart("file") MultipartFile multipartFile,
            UploadFileRequest uploadFileRequest, HttpServletRequest request) {
        String biz = uploadFileRequest.getBiz();
        FileUploadBizEnum fileUploadBizEnum = FileUploadBizEnum.getEnumByValue(biz);
        if (fileUploadBizEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        validFile(multipartFile, fileUploadBizEnum);
        User loginUser = userService.getLoginUser(request);
        // 鏂囦欢鐩綍锛氭牴鎹笟鍔°€佺敤鎴锋潵鍒掑垎
        String uuid = RandomStringUtils.randomAlphanumeric(8);
        String filename = uuid + "-" + multipartFile.getOriginalFilename();
        String filepath = String.format("/%s/%s/%s", fileUploadBizEnum.getValue(), loginUser.getId(), filename);
        File file = null;
        try {
            // 涓婁紶鏂囦欢
            file = File.createTempFile(filepath, null);
            multipartFile.transferTo(file);
            cosManager.putObject(filepath, file);
            // 杩斿洖鍙闂湴鍧€
            return ResultUtils.success(FileConstant.COS_HOST + filepath);
        } catch (Exception e) {
            log.error("file upload error, filepath = " + filepath, e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "涓婁紶澶辫触");
        } finally {
            if (file != null) {
                // 鍒犻櫎涓存椂鏂囦欢
                boolean delete = file.delete();
                if (!delete) {
                    log.error("file delete error, filepath = {}", filepath);
                }
            }
        }
    }

    /**
     * 鏍￠獙鏂囦欢
     *
     * @param multipartFile
     * @param fileUploadBizEnum 涓氬姟绫诲瀷
     */
    private void validFile(MultipartFile multipartFile, FileUploadBizEnum fileUploadBizEnum) {
        // 鏂囦欢澶у皬
        long fileSize = multipartFile.getSize();
        // 鏂囦欢鍚庣紑
        String fileSuffix = FileUtil.getSuffix(multipartFile.getOriginalFilename());
        final long ONE_M = 1024 * 1024L;
        if (FileUploadBizEnum.USER_AVATAR.equals(fileUploadBizEnum)) {
            if (fileSize > ONE_M) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "鏂囦欢澶у皬涓嶈兘瓒呰繃 1M");
            }
            if (!Arrays.asList("jpeg", "jpg", "svg", "png", "webp").contains(fileSuffix)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "鏂囦欢绫诲瀷閿欒");
            }
        }
    }
}

