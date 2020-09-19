import axios from 'axios'

const VEICULOS_API_URL = 'http://localhost:8080'
const BASE_API_URL = `${VEICULOS_API_URL}/`

class VeiculoDataService {
    retrieveAllVeiculos() {
        return axios.get(`${BASE_API_URL}/veiculos`);
    }

    retrieveVeiculosNaoVendidos() {
        return axios.get(`${BASE_API_URL}/veiculos/vendidos`);
    }

    deleteVeiculo(id) {
        return axios.delete(`${BASE_API_URL}/veiculos/${id}`);
    }

    retrieveVeiculo(id) {
        return axios.get(`${BASE_API_URL}/veiculos/${id}`);
    }

    async updateVeiculo(id, veiculo) {
        return await axios.put(`${BASE_API_URL}/veiculos/`, veiculo);
    }

    async createVeiculo(veiculo) {
        return await axios.post(`${BASE_API_URL}/veiculos/`, veiculo);
    }
}
export default new VeiculoDataService()