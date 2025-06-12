package com.example.orbitsong.api;
import com.example.orbitsong.models.Usuario;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {
    // Login del usuario
    @FormUrlEncoded
    @POST("api/usuarios/login")
    Call<Usuario> login(
            @Field("email") String email,
            @Field("contrasena") String contrasena
    );

    // Crear usuario (registro)
    @POST("api/usuarios")
    Call<Usuario> crearUsuario(@Body Usuario usuario);

    // Obtener usuario por ID
    @GET("api/usuarios/{id}")
    Call<Usuario> obtenerUsuario(@Path("id") Long id);

    // Obtener usuario por email
    @GET("api/usuarios/email/{email}")
    Call<Usuario> obtenerUsuarioPorEmail(@Path("email") String email);

    // Actualizar usuario
    @PUT("api/usuarios/{id}")
    Call<Usuario> actualizarUsuario(@Path("id") Long id, @Body Usuario usuario);
}
