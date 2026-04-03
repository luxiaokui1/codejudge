<template>
  <div id="questionSubmitView">
    <a-form :model="searchParams" layout="inline">
      <a-form-item
        field="questionId"
        label="Question ID"
        style="min-width: 220px"
      >
        <a-input
          v-model="searchParams.questionId"
          placeholder="Enter a question ID"
        />
      </a-form-item>
      <a-form-item field="language" label="Language" style="min-width: 260px">
        <a-select
          v-model="searchParams.language"
          placeholder="Select a language"
          allow-clear
        >
          <a-option value="java">java</a-option>
          <a-option value="cpp">cpp</a-option>
          <a-option value="go">go</a-option>
          <a-option value="html">html</a-option>
        </a-select>
      </a-form-item>
      <a-form-item
        ><a-button type="primary" @click="doSearch"
          >Search</a-button
        ></a-form-item
      >
    </a-form>
    <a-divider size="0" />
    <a-table
      :columns="columns"
      :data="dataList"
      :pagination="{
        showTotal: true,
        pageSize: searchParams.pageSize,
        current: searchParams.current,
        total,
      }"
      @page-change="onPageChange"
    >
      <template #status="{ record }"
        ><a-tag :color="getStatusColor(record.status)">{{
          getStatusText(record.status)
        }}</a-tag></template
      >
      <template #judgeInfo="{ record }">{{
        formatJudgeInfo(record.judgeInfo)
      }}</template>
      <template #createTime="{ record }">{{
        formatDateTime(record.createTime)
      }}</template>
    </a-table>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref, watchEffect } from "vue";
import {
  QuestionControllerService,
  QuestionSubmitQueryRequest,
} from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import moment from "moment";

const dataList = ref([]);
const total = ref(0);
const searchParams = ref<QuestionSubmitQueryRequest>({
  questionId: undefined,
  language: undefined,
  pageSize: 10,
  current: 1,
});
const columns = [
  { title: "Submission ID", dataIndex: "id" },
  { title: "Language", dataIndex: "language" },
  { title: "Judge Info", slotName: "judgeInfo" },
  { title: "Status", slotName: "status" },
  { title: "Question ID", dataIndex: "questionId" },
  { title: "User ID", dataIndex: "userId" },
  { title: "Created At", slotName: "createTime" },
];

const loadData = async () => {
  const res = await QuestionControllerService.listQuestionSubmitByPageUsingPost(
    searchParams.value
  );
  if (res.code === 0) {
    dataList.value = res.data.records;
    total.value = res.data.total;
  } else {
    message.error(`Failed to load submissions: ${res.message}`);
  }
};

watchEffect(() => {
  loadData();
});
onMounted(() => {
  loadData();
});
const onPageChange = (page: number) => {
  searchParams.value = { ...searchParams.value, current: page };
};
const doSearch = () => {
  searchParams.value = { ...searchParams.value, current: 1 };
};

const getStatusText = (status: number) => {
  switch (status) {
    case 0:
      return "Waiting";
    case 1:
      return "Judging";
    case 2:
      return "Finished";
    case 3:
      return "Failed";
    default:
      return "Unknown";
  }
};
const getStatusColor = (status: number) => {
  switch (status) {
    case 0:
      return "gray";
    case 1:
      return "arcoblue";
    case 2:
      return "green";
    case 3:
      return "red";
    default:
      return "gray";
  }
};
const formatJudgeInfo = (judgeInfoText: string) => {
  if (!judgeInfoText) return "Processing";
  try {
    const judgeInfo = JSON.parse(judgeInfoText);
    const segments = [];
    if (judgeInfo.message) segments.push(`Result: ${judgeInfo.message}`);
    if (judgeInfo.time !== null && judgeInfo.time !== undefined)
      segments.push(`Time: ${judgeInfo.time} ms`);
    if (judgeInfo.memory !== null && judgeInfo.memory !== undefined)
      segments.push(`Memory: ${judgeInfo.memory} KB`);
    return segments.length ? segments.join(" | ") : "Processing";
  } catch (error) {
    return judgeInfoText;
  }
};
const formatDateTime = (value: string) =>
  value ? moment(value).format("YYYY-MM-DD HH:mm:ss") : "-";
</script>

<style scoped>
#questionSubmitView {
  max-width: 1280px;
  margin: 0 auto;
}
</style>
