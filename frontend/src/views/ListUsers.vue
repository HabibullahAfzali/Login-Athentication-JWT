<script setup>
import { ref, onMounted } from 'vue';
import Navbar from '../components/Navbar.vue';
import axios from 'axios';

const registeredUsers = ref([]);

onMounted(async () => {
    try {
        const response = await axios.get('http://localhost:8080/api/users');
        registeredUsers.value = response.data.map(user => {
         
            return {
                username: user.username,
                email: user.email,
                roles: user.roles
            }
        });
    } catch (error) {
        console.error('Error fetching registered users:', error);
    }
});
</script>
<template>
    <main>
        <Navbar />
        <div class="container mt-5">
            <h1 class="text-center mb-4" style="color: hsl(218, 81%, 75%)">Users</h1>
            <div class="row justify-content-center">
                <div class="col-md-4 mb-4" v-for="(user, index) in registeredUsers" :key="index">
                    <div class="card">
                        <div class="card-body text-center">
                            <h5 class="card-title mt-3">{{ user.username }}</h5>
                            <p class="card-text">{{ user.email }}</p>
                            <p class="card-text">{{ user.roles.map(role=>role.name).join(',') }}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</template>
<style scoped>
.profile-picture {
    width: 120px;
    height: 120px;
    border-radius: 50%;
    overflow: hidden;
    margin: 0 auto;
}

.profile-picture img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.card {
    border: none;
    background-color: transparent;
    transition: transform 0.3s ease;
}

.card:hover {
    transform: translateY(-5px);
}

.card-title {
    margin-top: 10px;
    font-size: 1.25rem;
    color: hsl(218, 81%, 75%);
}

.card-text {
    color: hsl(218, 81%, 85%);
}
</style>