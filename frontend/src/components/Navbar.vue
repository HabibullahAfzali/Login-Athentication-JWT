<script>
</script>
<template>
    <main>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container-fluid">
                <a class="navbar-brand" href="/">Login</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <router-link to="/listusers" exact class="nav-link"
                            exact-active-class="active">Users</router-link>
                        <router-link to="/register" exact class="nav-link" exact-active-class="active">SignUp</router-link>
                        <router-link to="/roleassign" exact class="nav-link" exact-active-class="active">Assign-Roles</router-link>
                    </ul>

                </div>
            </div>
        </nav>
    </main>
</template>