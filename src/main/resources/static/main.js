new Vue({
  el: '#app',
  data () {
    return {
      search: "",
      usuario: {},
      usuarios: []
    }
  },
  methods: {
    salvar: function (event) {
        axios.post('/api/usuario', this.usuario)
        .then((response) => {
          console.log(response.data);
          this.usuarios.push(response.data);
          this.usuario = {}
        }, (error) => {
          console.log(error);
        });
    },
    buscarPorNome: function (event) {
            event.preventDefault();
            axios
            .get('/api/usuario', { params: { nome: this.search } })
            .then(response => (this.usuarios = response.data))
    },
    excluirTodosUsuarios: function (event) {
        event.preventDefault();
        axios.delete('/api/usuario')
                .then((response) => {
                  this.usuarios = []
                }, (error) => {
                  console.log(error);
                });
    }
  },
  mounted () {
    axios
      .get('/api/usuario')
      .then(response => (this.usuarios = response.data))
  }
})