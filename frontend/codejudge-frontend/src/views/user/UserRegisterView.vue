<template>
  <div id="userRegisterView">
    <h2 style="margin-bottom: 16px">Create Account</h2>
    <a-form
      style="max-width: 480px; margin: 0 auto"
      label-align="left"
      auto-label-width
      :model="form"
      @submit="handleSubmit"
    >
      <a-form-item field="userAccount" label="Account">
        <a-input
          v-model="form.userAccount"
          placeholder="Choose an account name"
        />
      </a-form-item>
      <a-form-item
        field="userPassword"
        tooltip="Password must be at least 8 characters"
        label="Password"
      >
        <a-input-password
          v-model="form.userPassword"
          placeholder="Enter a password"
        />
      </a-form-item>
      <a-form-item field="checkPassword" label="Confirm Password">
        <a-input-password
          v-model="form.checkPassword"
          placeholder="Enter the password again"
        />
      </a-form-item>
      <a-form-item>
        <a-button type="primary" html-type="submit" style="width: 120px"
          >Register</a-button
        >
      </a-form-item>
      <a-form-item>
        Already have an account?
        <a-link @click="router.push('/user/login')">Sign in</a-link>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { reactive } from "vue";
import { UserControllerService, UserRegisterRequest } from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";

const form = reactive({
  userAccount: "",
  userPassword: "",
  checkPassword: "",
} as UserRegisterRequest);
const router = useRouter();

const handleSubmit = async () => {
  if (form.userPassword !== form.checkPassword) {
    message.error("The two passwords do not match.");
    return;
  }
  const res = await UserControllerService.userRegisterUsingPost(form);
  if (res.code === 0) {
    message.success("Registration completed. Please sign in.");
    router.push({ path: "/user/login" });
  } else {
    message.error(`Registration failed: ${res.message}`);
  }
};
</script>
