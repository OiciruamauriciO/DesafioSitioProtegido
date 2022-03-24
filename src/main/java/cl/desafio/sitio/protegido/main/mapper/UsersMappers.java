package cl.desafio.sitio.protegido.main.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cl.desafio.sitio.protegido.main.model.Users;

@Mapper
public interface UsersMappers {

	@Select("select * from users where email = #{email}")
	Users findByEmail(@Param("email") String email);
}
