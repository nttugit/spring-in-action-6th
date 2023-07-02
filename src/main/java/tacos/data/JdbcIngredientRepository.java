package tacos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tacos.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	// @Autowired sử dụng để Spring wire (inject) explicitly, còn không thì nó sẽ autowiring implicitly
	@Autowired
	public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Iterable<Ingredient> findAll() {
		return jdbcTemplate.query("Select id, name, type from Ingredient", this::mapRowToIngredient);
	}

	@Override
	public Optional<Ingredient> findById(String id) {
		List<Ingredient> results = 
				jdbcTemplate.query("Select id, name, type from Ingredient Where id=?",
						this::mapRowToIngredient,
						id);
		
		return results.size() == 0 ? Optional.empty() : Optional.of(results.get(0));
	}
	
	// Cách 2: Có thể định nghĩa RowMapper explicitly
//	@Override
//	public Optional<Ingredient> findById(String id) {
//		return 
//				jdbcTemplate.queryForObject(
// 					"Select id, name, type from Ingredient Where id=?",
//						new RowMapper<Ingredient>() {
//							public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException{
//								return new Ingredient(
//										rs.getString("id"),
//										rs.getString("name"),
//										Ingredient.Type.valueOf(rs.getString("type"))
//									);
//								}
//							}
//							,id);
//	}
	
	@Override
	public Ingredient save(Ingredient ingredient) {
		jdbcTemplate.update(
				"insert into Ingredient (id, name, type) values (?, ?, ?)",
				ingredient.getId(),
				ingredient.getName(),
				ingredient.getType().toString()
				);
		return ingredient;
	}
	
	private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
		return new Ingredient(
				row.getString("id"),
				row.getString("name"),
				Ingredient.Type.valueOf(row.getString("type"))
				);
	}
	
	
	

	
}
