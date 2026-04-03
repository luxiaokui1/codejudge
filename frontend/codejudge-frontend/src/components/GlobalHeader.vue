<template>
  <a-row id="globalHeader" align="center" :wrap="false">
    <a-col flex="auto">
      <a-menu
        mode="horizontal"
        :selected-keys="selectedKeys"
        @menu-item-click="doMenuClick"
      >
        <a-menu-item
          key="brand"
          :style="{ padding: 0, marginRight: '38px' }"
          disabled
        >
          <div class="title-bar">
            <img
              class="logo"
              src="../assets/oj-logo.svg"
              alt="CodeJudge logo"
            />
            <div class="title">CodeJudge</div>
          </div>
        </a-menu-item>
        <a-menu-item v-for="item in visibleRoutes" :key="item.path">{{
          item.name
        }}</a-menu-item>
      </a-menu>
    </a-col>
    <a-col flex="160px">
      <div
        v-if="
          store.state.user?.loginUser?.userRole &&
          store.state.user.loginUser.userRole !== 'notLogin'
        "
        class="user-name"
      >
        {{ store.state.user.loginUser.userName }}
      </div>
      <a-button v-else type="primary" @click="router.push('/user/login')"
        >Login</a-button
      >
    </a-col>
  </a-row>
</template>

<script setup lang="ts">
import { routes } from "../router/routes";
import { useRouter } from "vue-router";
import { computed, ref } from "vue";
import { useStore } from "vuex";
import checkAccess from "@/access/checkAccess";

const router = useRouter();
const store = useStore();

const visibleRoutes = computed(() => {
  return routes.filter((item) => {
    if (item.meta?.hideInMenu) return false;
    return checkAccess(
      store.state.user.loginUser,
      item?.meta?.access as string
    );
  });
});

const selectedKeys = ref([router.currentRoute.value.path || "/"]);
router.afterEach((to) => {
  selectedKeys.value = [to.path];
});

const doMenuClick = (key: string) => {
  if (key !== "brand") router.push({ path: key });
};
</script>

<style scoped>
.title-bar {
  display: flex;
  align-items: center;
}
.title {
  color: #1d2129;
  margin-left: 12px;
  font-size: 18px;
  font-weight: 600;
}
.logo {
  height: 42px;
  width: 42px;
}
.user-name {
  text-align: right;
  color: #4e5969;
  font-weight: 500;
}
</style>
