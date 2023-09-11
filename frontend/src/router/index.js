import { createRouter, createWebHistory } from "vue-router";
import SignUp from "../views/Register.vue";
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "register",
      component: SignUp,
    },
    {
      path: "/listusers",
      name: "ListsUsers",
      component: () => import("../views/ListUsers.vue"),
    },

    {
      path: "/update/:id",
      name: "update",
      component: () => import("../views/UpdateUser.vue"),
    },
  ],
});

export default router;
