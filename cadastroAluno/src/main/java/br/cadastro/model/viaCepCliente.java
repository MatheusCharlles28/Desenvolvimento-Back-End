package br.cadastro.model;
import org.apache.http.client.fluent.Request;
import com.google.gson.Gson;
import br.cadastro.model.Endereco;
public class viaCepCliente {
    public static Endereco buscarCep(String cep) throws Exception {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        String jsonResponse = Request.Get(url)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, Endereco.class);
    }

}
