package com.codejudge.platform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codejudge.platform.model.dto.user.UserQueryRequest;
import com.codejudge.platform.model.entity.User;
import com.codejudge.platform.model.vo.LoginUserVO;
import com.codejudge.platform.model.vo.UserVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;

/**
 * 鐢ㄦ埛鏈嶅姟
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
public interface UserService extends IService<User> {

    /**
     * 鐢ㄦ埛娉ㄥ唽
     *
     * @param userAccount   鐢ㄦ埛璐︽埛
     * @param userPassword  鐢ㄦ埛瀵嗙爜
     * @param checkPassword 鏍￠獙瀵嗙爜
     * @return 鏂扮敤鎴?id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 鐢ㄦ埛鐧诲綍
     *
     * @param userAccount  鐢ㄦ埛璐︽埛
     * @param userPassword 鐢ㄦ埛瀵嗙爜
     * @param request
     * @return 鑴辨晱鍚庣殑鐢ㄦ埛淇℃伅
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 鐢ㄦ埛鐧诲綍锛堝井淇″紑鏀惧钩鍙帮級
     *
     * @param wxOAuth2UserInfo 浠庡井淇¤幏鍙栫殑鐢ㄦ埛淇℃伅
     * @param request
     * @return 鑴辨晱鍚庣殑鐢ㄦ埛淇℃伅
     */
    LoginUserVO userLoginByMpOpen(WxOAuth2UserInfo wxOAuth2UserInfo, HttpServletRequest request);

    /**
     * 鑾峰彇褰撳墠鐧诲綍鐢ㄦ埛
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 鑾峰彇褰撳墠鐧诲綍鐢ㄦ埛锛堝厑璁告湭鐧诲綍锛?
     *
     * @param request
     * @return
     */
    User getLoginUserPermitNull(HttpServletRequest request);

    /**
     * 鏄惁涓虹鐞嗗憳
     *
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 鏄惁涓虹鐞嗗憳
     *
     * @param user
     * @return
     */
    boolean isAdmin(User user);

    /**
     * 鐢ㄦ埛娉ㄩ攢
     *
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 鑾峰彇鑴辨晱鐨勫凡鐧诲綍鐢ㄦ埛淇℃伅
     *
     * @return
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 鑾峰彇鑴辨晱鐨勭敤鎴蜂俊鎭?
     *
     * @param user
     * @return
     */
    UserVO getUserVO(User user);

    /**
     * 鑾峰彇鑴辨晱鐨勭敤鎴蜂俊鎭?
     *
     * @param userList
     * @return
     */
    List<UserVO> getUserVO(List<User> userList);

    /**
     * 鑾峰彇鏌ヨ鏉′欢
     *
     * @param userQueryRequest
     * @return
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

}

