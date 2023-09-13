import { createRouter, createWebHistory } from "vue-router";
import Login from "../views/LoginView.vue";
import SignUp from "../views/RegisterView.vue";
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "login",
      component: Login,
    },
    {
      path: "/register",
      name: "register",
      component: SignUp,
    },
    {
      path: "/listusers",
      name: "ListsUsers",
      component: () => import("../views/ListUsersView.vue"),
    },
    {
      path: "/roleassign",
      name: "roleassign",
      component: () => import("../views/RoleAssignView.vue"),
    },

    {
      path: "/update/:id",
      name: "update",
      component: () => import("../views/UpdateUserView.vue"),
    },
  ],
});

export default router;
