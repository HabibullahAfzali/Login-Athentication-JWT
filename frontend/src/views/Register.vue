<script setup>
import Navbar from '../components/Navbar.vue';
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const user = ref({
    username: '',
    email: '',
    password: ''
});
const roles = ref([]);
const selectedRole = ref("Select_from_list");
const route = useRouter();

const signUp = async () => {
        const newUser = {
        ...user.value,
        role: { id: selectedRole.value } 
    };

    axios.post('http://localhost:8080/api/createUser', newUser)
        .then(() => {
            alert("User successfully added!");
            route.push('/listusers');
        })
        .catch(error => {
            console.error("Not able to add user:", error);
        });
};

const fetchRoles = () => {
    axios.get('http://localhost:8080/api/roles')
        .then(res => {
            roles.value = res.data;
        }).catch(error => {
            console.error('Roles not found!', error);
        });
};

onMounted(() => {
    fetchRoles();
});
</script>
<template>
    <main>
        <Navbar />
        <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                        Bienvenidos a <br />
                        <span style="color: hsl(218, 81%, 75%)">la LoginApp</span>
                    </h1>
                    <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
                        Para ver tus avances en el desarrollo de software
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
                                <!-- Role Dropdown -->
                                <div class="row">
                                    <div class="col-md-12 form-group mb-3">
                                        <label for="name" class="form-label">Role</label>
                                        <select id="name" name="name" class="form-control" v-model="selectedRole">
                                            <option value="Select_from_list" disabled>Select_from_list</option>
                                            <option v-for="role in roles" :key="role.id" :value="role.id">{{ role.name
                                            }}</option>
                                        </select>
                                    </div>
                                </div>
                                <br><br>
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <input class="btn btn-secondary w-100" type="submit" value="Submit">
                                    </div>
                                </div>
                                <div class="text-center">
                                    <p> Already Have an Account </p>
                                    <a href="/Welcome">login</a>
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
