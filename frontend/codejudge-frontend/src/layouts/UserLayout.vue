<template>
  <div id="userLayout">
    <a-layout style="min-height: 100vh">
      <a-layout-header class="header">
        <a-space>
          <img src="../assets/oj-logo.svg" class="logo" alt="CodeJudge logo" />
          <div class="brand">CodeJudge</div>
        </a-space>
      </a-layout-header>
      <a-layout-content class="content"><router-view /></a-layout-content>
      <a-layout-footer class="footer">
        Sign in to manage questions, submit code, and review judging results.
      </a-layout-footer>
    </a-layout>
  </div>
</template>

<style scoped>
#userLayout {
  text-align: center;
  background: url("https://gw.alipayobjects.com/zos/rmsportal/FfdJeJRQWjEeGTpqgBKj.png")
    0% 0% / 100% 100%;
}
#userLayout .logo {
  width: 52px;
  height: 52px;
}
#userLayout .brand {
  font-size: 20px;
  font-weight: 700;
  color: #1d2129;
}
#userLayout .header {
  margin-top: 16px;
}
#userLayout .content {
  margin-bottom: 16px;
  padding: 20px;
}
#userLayout .footer {
  padding: 16px;
  position: sticky;
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
  color: #4e5969;
}
</style>
<script></script>
