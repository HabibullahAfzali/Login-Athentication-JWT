<script setup>
import { ref} from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const user = ref({
    username: '',
    email: '',
    password: ''
});

const route = useRouter();

const signUp = async () => {
        const newUser = {
        ...user.value
    };

    axios.post('http://localhost:8080/api/createUser', newUser)
        .then(() => {
            alert("User successfully added!");
            route.push('/');
        })
        .catch(error => {
            console.error("Not able to add user:", error);
        });
};

</script>
<template>
    <main>
        <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                        Welcome To The <br />
                        <span style="color: hsl(218, 81%, 75%)">Registeration Page</span>
                    </h1>
                    <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
                        It's important to note your password
                    </p>
                </div>

                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                    <div class="card bg-glass">
                        <h1 class="mt-3 display-5 fw-bold ls-tight text-center" style="color: hsl(218, 81%, 75%)">SignUp
                        </h1>
                        <div class="card-body px-4 py-5 px-md-5">
                            <form @submit.prevent="signUp">
                                <div class="form-outline mb-4">
                                    <input type="text" class="form-control center" v-model="user.username" />
                                    <label class="form-label" for="form3Example1">UserName</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="email" class="form-control" v-model="user.email" />
                                    <label class="form-label" for="form3Example2">Email</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="password" class="form-control" v-model="user.password" />
                                    <label class="form-label" for="form3Example4">Password</label>
                                </div>
                                <br><br>
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <input class="btn btn-primary w-100" type="submit" value="Submit">
                                    </div>
                                </div>
                            <br/>
                                <br/>
                                <div class="text-center">
                                    <p> Already Have an Account </p>
                                    <a href="/">login</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</template>

<style scoped>
.profile-picture-label {
    display: inline-block;
    width: 120px;
    height: 120px;
    border-radius: 50%;
    background-color: #e2e2df;
    text-align: center;
    line-height: 120px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.profile-picture-label i {
    font-size: 36px;
}

.profile-picture-label:hover {
    background-color: #0a6fea;
}
</style>
