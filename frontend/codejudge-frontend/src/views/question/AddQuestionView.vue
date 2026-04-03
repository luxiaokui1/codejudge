<template>
  <div id="addQuestionView">
    <h2>{{ updatePage ? "Update Question" : "Create Question" }}</h2>
    <a-form :model="form" label-align="left">
      <a-form-item field="title" label="Title">
        <a-input v-model="form.title" placeholder="Enter a question title" />
      </a-form-item>
      <a-form-item field="tags" label="Tags">
        <a-input-tag
          v-model="form.tags"
          placeholder="Add one or more tags"
          allow-clear
        />
      </a-form-item>
      <a-form-item field="content" label="Problem Statement">
        <MdEditor :value="form.content" :handle-change="onContentChange" />
      </a-form-item>
      <a-form-item field="answer" label="Reference Answer">
        <MdEditor :value="form.answer" :handle-change="onAnswerChange" />
      </a-form-item>
      <a-form-item
        label="Judge Configuration"
        :content-flex="false"
        :merge-props="false"
      >
        <a-space direction="vertical" style="min-width: 480px">
          <a-form-item field="judgeConfig.timeLimit" label="Time Limit (ms)">
            <a-input-number
              v-model="form.judgeConfig.timeLimit"
              placeholder="Enter the time limit"
              mode="button"
              min="0"
              size="large"
            />
          </a-form-item>
          <a-form-item
            field="judgeConfig.memoryLimit"
            label="Memory Limit (KB)"
          >
            <a-input-number
              v-model="form.judgeConfig.memoryLimit"
              placeholder="Enter the memory limit"
              mode="button"
              min="0"
              size="large"
            />
          </a-form-item>
          <a-form-item field="judgeConfig.stackLimit" label="Stack Limit (KB)">
            <a-input-number
              v-model="form.judgeConfig.stackLimit"
              placeholder="Enter the stack limit"
              mode="button"
              min="0"
              size="large"
            />
          </a-form-item>
        </a-space>
      </a-form-item>
      <a-form-item
        label="Test Cases"
        :content-flex="false"
        :merge-props="false"
      >
        <a-form-item
          v-for="(judgeCaseItem, index) of form.judgeCase"
          :key="index"
          no-style
        >
          <a-space direction="vertical" style="min-width: 640px">
            <a-form-item
              :field="`form.judgeCase[${index}].input`"
              :label="`Input ${index + 1}`"
            >
              <a-input
                v-model="judgeCaseItem.input"
                placeholder="Enter the sample input"
              />
            </a-form-item>
            <a-form-item
              :field="`form.judgeCase[${index}].output`"
              :label="`Output ${index + 1}`"
            >
              <a-input
                v-model="judgeCaseItem.output"
                placeholder="Enter the expected output"
              />
            </a-form-item>
            <a-button status="danger" @click="handleDelete(index)"
              >Delete</a-button
            >
          </a-space>
        </a-form-item>
        <div style="margin-top: 32px">
          <a-button @click="handleAdd" type="outline" status="success"
            >Add Test Case</a-button
          >
        </div>
      </a-form-item>
      <div style="margin-top: 16px" />
      <a-form-item>
        <a-button type="primary" style="min-width: 200px" @click="doSubmit">{{
          updatePage ? "Save Changes" : "Create Question"
        }}</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref } from "vue";
import MdEditor from "@/components/MdEditor.vue";
import { QuestionControllerService } from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRoute } from "vue-router";

const route = useRoute();
const updatePage = route.path.includes("update");

let form = ref({
  title: "",
  tags: [],
  answer: "",
  content: "",
  judgeConfig: { memoryLimit: 1000, stackLimit: 1000, timeLimit: 1000 },
  judgeCase: [{ input: "", output: "" }],
});

const loadData = async () => {
  const id = route.query.id;
  if (!id) return;
  const res = await QuestionControllerService.getQuestionByIdUsingGet(
    id as any
  );
  if (res.code === 0) {
    form.value = res.data as any;
    form.value.judgeCase = form.value.judgeCase
      ? JSON.parse(form.value.judgeCase as any)
      : [{ input: "", output: "" }];
    form.value.judgeConfig = form.value.judgeConfig
      ? JSON.parse(form.value.judgeConfig as any)
      : { memoryLimit: 1000, stackLimit: 1000, timeLimit: 1000 };
    form.value.tags = form.value.tags ? JSON.parse(form.value.tags as any) : [];
  } else {
    message.error(`Failed to load question: ${res.message}`);
  }
};

onMounted(() => {
  loadData();
});

const doSubmit = async () => {
  if (updatePage) {
    const res = await QuestionControllerService.updateQuestionUsingPost(
      form.value
    );
    if (res.code === 0) {
      message.success("Question updated successfully.");
    } else {
      message.error(`Failed to update question: ${res.message}`);
    }
  } else {
    const res = await QuestionControllerService.addQuestionUsingPost(
      form.value
    );
    if (res.code === 0) {
      message.success("Question created successfully.");
    } else {
      message.error(`Failed to create question: ${res.message}`);
    }
  }
};

const handleAdd = () => {
  form.value.judgeCase.push({ input: "", output: "" });
};
const handleDelete = (index: number) => {
  form.value.judgeCase.splice(index, 1);
};
const onContentChange = (value: string) => {
  form.value.content = value;
};
const onAnswerChange = (value: string) => {
  form.value.answer = value;
};
</script>

<style scoped>
#addQuestionView {
}
</style>
