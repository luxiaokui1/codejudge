<template>
  <div id="userLoginView">
    <h2 style="margin-bottom: 16px">User Login</h2>
    <a-form
      style="max-width: 480px; margin: 0 auto"
      label-align="left"
      auto-label-width
      :model="form"
      @submit="handleSubmit"
    >
      <a-form-item field="userAccount" label="Account">
        <a-input v-model="form.userAccount" placeholder="Enter your account" />
      </a-form-item>
      <a-form-item
        field="userPassword"
        tooltip="Password must be at least 8 characters"
        label="Password"
      >
        <a-input-password
          v-model="form.userPassword"
          placeholder="Enter your password"
        />
      </a-form-item>
      <a-form-item>
        <a-button type="primary" html-type="submit" style="width: 120px"
          >Login</a-button
        >
      </a-form-item>
      <a-form-item>
        Don&apos;t have an account?
        <a-link @click="router.push('/user/register')">Create one</a-link>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { reactive } from "vue";
import { UserControllerService, UserLoginRequest } from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

const form = reactive({
  userAccount: "",
  userPassword: "",
} as UserLoginRequest);
const router = useRouter();
const store = useStore();

const handleSubmit = async () => {
  const res = await UserControllerService.userLoginUsingPost(form);
  if (res.code === 0) {
    await store.dispatch("user/getLoginUser");
    router.push({ path: "/", replace: true });
  } else {
    message.error(`Login failed: ${res.message}`);
  }
};
</script>
