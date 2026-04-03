<template>
  <div id="questionsView">
    <a-form :model="searchParams" layout="inline">
      <a-form-item field="title" label="Title" style="min-width: 240px">
        <a-input v-model="searchParams.title" placeholder="Search by title" />
      </a-form-item>
      <a-form-item field="tags" label="Tags" style="min-width: 240px">
        <a-input-tag v-model="searchParams.tags" placeholder="Filter by tags" />
      </a-form-item>
      <a-form-item>
        <a-button type="primary" @click="doSubmit">Search</a-button>
      </a-form-item>
    </a-form>
    <a-divider size="0" />
    <a-table
      :ref="tableRef"
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
      <template #tags="{ record }">
        <a-space wrap>
          <a-tag
            v-for="(tag, index) of record.tags"
            :key="index"
            color="green"
            >{{ tag }}</a-tag
          >
        </a-space>
      </template>
      <template #acceptedRate="{ record }">
        {{
          `${
            record.submitNum
              ? ((record.acceptedNum / record.submitNum) * 100).toFixed(2)
              : "0.00"
          }% (${record.acceptedNum}/${record.submitNum})`
        }}
      </template>
      <template #createTime="{ record }">{{
        moment(record.createTime).format("YYYY-MM-DD")
      }}</template>
      <template #optional="{ record }">
        <a-space
          ><a-button type="primary" @click="toQuestionPage(record)"
            >Solve</a-button
          ></a-space
        >
      </template>
    </a-table>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref, watchEffect } from "vue";
import {
  Question,
  QuestionControllerService,
  QuestionQueryRequest,
} from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";
import moment from "moment";

const tableRef = ref();
const dataList = ref([]);
const total = ref(0);
const searchParams = ref<QuestionQueryRequest>({
  title: "",
  tags: [],
  pageSize: 8,
  current: 1,
});

const loadData = async () => {
  const res = await QuestionControllerService.listQuestionVoByPageUsingPost(
    searchParams.value
  );
  if (res.code === 0) {
    dataList.value = res.data.records;
    total.value = res.data.total;
  } else {
    message.error(`Failed to load questions: ${res.message}`);
  }
};

watchEffect(() => {
  loadData();
});
onMounted(() => {
  loadData();
});

const columns = [
  { title: "Question ID", dataIndex: "id" },
  { title: "Title", dataIndex: "title" },
  { title: "Tags", slotName: "tags" },
  { title: "Acceptance Rate", slotName: "acceptedRate" },
  { title: "Created At", slotName: "createTime" },
  { title: "Action", slotName: "optional" },
];

const onPageChange = (page: number) => {
  searchParams.value = { ...searchParams.value, current: page };
};
const router = useRouter();
const toQuestionPage = (question: Question) => {
  router.push({ path: `/view/question/${question.id}` });
};
const doSubmit = () => {
  searchParams.value = { ...searchParams.value, current: 1 };
};
</script>

<style scoped>
#questionsView {
  max-width: 1280px;
  margin: 0 auto;
}
</style>
