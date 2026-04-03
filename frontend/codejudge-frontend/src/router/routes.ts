import { RouteRecordRaw } from "vue-router";
import UserLayout from "@/layouts/UserLayout.vue";
import UserLoginView from "@/views/user/UserLoginView.vue";
import UserRegisterView from "@/views/user/UserRegisterView.vue";
import NoAuthView from "@/views/NoAuthView.vue";
import ACCESS_ENUM from "@/access/accessEnum";
import AddQuestionView from "@/views/question/AddQuestionView.vue";
import ManageQuestionView from "@/views/question/ManageQuestionView.vue";
import QuestionsView from "@/views/question/QuestionsView.vue";
import QuestionSubmitView from "@/views/question/QuestionSubmitView.vue";
import ViewQuestionView from "@/views/question/ViewQuestionView.vue";

export const routes: Array<RouteRecordRaw> = [
  {
    path: "/user",
    name: "User",
    component: UserLayout,
    children: [
      { path: "/user/login", name: "Login", component: UserLoginView },
      { path: "/user/register", name: "Register", component: UserRegisterView },
    ],
    meta: { hideInMenu: true },
  },
  { path: "/questions", name: "Questions", component: QuestionsView },
  {
    path: "/question_submit",
    name: "Submissions",
    component: QuestionSubmitView,
  },
  {
    path: "/view/question/:id",
    name: "Solve Question",
    component: ViewQuestionView,
    props: true,
    meta: { access: ACCESS_ENUM.USER, hideInMenu: true },
  },
  {
    path: "/add/question",
    name: "Create Question",
    component: AddQuestionView,
    meta: { access: ACCESS_ENUM.USER },
  },
  {
    path: "/update/question",
    name: "Update Question",
    component: AddQuestionView,
    meta: { access: ACCESS_ENUM.USER, hideInMenu: true },
  },
  {
    path: "/manage/question/",
    name: "Manage Questions",
    component: ManageQuestionView,
    meta: { access: ACCESS_ENUM.ADMIN },
  },
  { path: "/", name: "Home", component: QuestionsView },
  {
    path: "/noAuth",
    name: "No Access",
    component: NoAuthView,
    meta: { hideInMenu: true },
  },
];
