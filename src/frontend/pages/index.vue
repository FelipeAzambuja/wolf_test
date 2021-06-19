<template>
    <div
        class="container"
        v-if="state && imc && obsity && blood_type && qtd_blood_type"
    >
        <h1 class="text-center mt-4">Candidatos</h1>
        <h3 class="mt-4">Por estado</h3>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th v-for="item in state.data" :key="item[0]">
                        {{ item[0] }}
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td v-for="item in state.data" :key="item[0]">
                        {{ item[1] }}
                    </td>
                </tr>
            </tbody>
        </table>

        <h3 class="mt-4">IMC médio por faixa de idade</h3>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Anos</th>
                    <th v-for="item in imc.data" :key="item[0]">
                        {{ item[0][1] }} - {{ item[0][2] }}
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><b>IMC</b></td>
                    <td v-for="item in imc.data" :key="item[0]">
                        <span v-if="item[0][0] > 0">
                            {{ item[0][0] }}
                        </span>
                        <span v-else> - </span>
                    </td>
                </tr>
            </tbody>
        </table>

        <h3 class="mt-4">Percentual Obsidade por sexo</h3>
        <ul>
            <li>Homens: {{ obsity.data[1][0] }}%</li>
            <li>Mulheres: {{ obsity.data[0][0] }}%</li>
        </ul>
        <h3 class="mt-4">Média de Idade tipo sanguíneo</h3>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th v-for="item in blood_type.data" :key="item[0]">
                        {{ item[0] }}
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td v-for="item in blood_type.data" :key="item[0]">
                        {{ item[1] }}
                    </td>
                </tr>
            </tbody>
        </table>
        <h3 class="mt-4">Doadores por tipo sanguíneo</h3>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th v-for="item in qtd_blood_type.data" :key="item[0]">
                        {{ item[0] }}
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td v-for="item in qtd_blood_type.data" :key="item[0]">
                        {{ item[1] }}
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
    data() {
        return {
            state: null,
            imc: null,
            obsity: null,
            blood_type: null,
            qtd_blood_type: null,
        };
    },
    async mounted() {
        this.state = await this.$axios.get(
            "http://localhost:8080/api/report/state"
        );
        this.imc = await this.$axios.get(
            "http://localhost:8080/api/report/imc"
        );
        this.obsity = await this.$axios.get(
            "http://localhost:8080/api/report/obsity"
        );
        this.blood_type = await this.$axios.get(
            "http://localhost:8080/api/report/blood_type"
        );
        this.qtd_blood_type = await this.$axios.get(
            "http://localhost:8080/api/report/qtd_blood_type"
        );
    },
});
</script>

<style>
</style>
