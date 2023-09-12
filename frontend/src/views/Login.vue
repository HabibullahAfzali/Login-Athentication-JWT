<script setup>
import Navbar from '../components/Navbar.vue';
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';
const route = useRouter();

const user = ref({
    username: '',
    password: ''
});
const login = async (user) => {
    axios.post('http://localhost:8080/login', user)
        .then(() => {
            alert("User successfully logged in!");
            route.push("/listusers")
        })
        .catch(error => {
            console.error("Login failed:", error);
        });
};
</script>

<template>
    <main>
        <Navbar />
        <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                        Welcome to <br />
                        <span style="color: hsl(218, 81%, 75%)">User Authentication</span>
                    </h1>
                    <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
                        Try to use the Correct UserName and Password
                    </p>
                </div>

                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                    <div class="card bg-glass">
                        <h1 class="mt-3 display-5 fw-bold ls-tight text-center" style="color: hsl(218, 81%, 75%)">Login
                        </h1>
                        <div class="card-body px-4 py-5 px-md-5">
                            <form @submit.prevent="login(user)">
                                <div class="form-outline mb-4">
                                    <input type="text" id="userName" class="form-control center" v-model="user.username" />
                                    <label class="form-label" for="userName">User name</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="password" id="password" class="form-control" v-model="user.password" />
                                    <label class="form-label" for="password">Password</label>
                                </div>
                                <button type="submit" class="btn btn-primary btn-block mb-4 w-100">
                                    Login
                                </button>
                                <div class="text-center">
                                    <p> Not have an account </p>
                                    <a href="/register">Register</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</template>