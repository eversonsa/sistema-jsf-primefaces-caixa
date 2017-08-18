package br.com.framework.interfaces.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface InterfaceCrud<T> extends Serializable {
	
	void salvar(T objeto) throws Exception;
	
	void inserir(T objeto) throws Exception;
	
	void salvarOuAtualizar(T objeto) throws Exception;
	
	void atualizar(T objeto) throws Exception;
	
	void deletar(T objeto) throws Exception;
	
	T merge (T objeto) throws Exception;
	
	List<T> encontrarLista(Class<T> objeto) throws Exception;
	
	Object encontrarId(Class<T> entidade, long id) throws Exception;
	
	T encontrarPorId(Class<T> enidade, long id) throws Exception;
	
	List<T> encontrarPorQueryDinamica(String s) throws Exception;
	
	//executar update com HQL
	void executarAtualizacaoPorQueryDinamica(String s) throws Exception;
	
	//executar update com sql
	void executarAtualizacaoSQLDinamico(String s) throws Exception;
	
	//limpar cache do hibernate
	void limparSession() throws Exception;
	
	//retira um objeto da sessao do hibernate
	void evict(Object objeto) throws Exception;
	
	//
	Session getSession() throws Exception;
	
	List<?> getListaSQLDinamico(String sql) throws Exception;
	
	//JDBC do SPRING
	JdbcTemplate getJdbcTemplate();
	SimpleJdbcTemplate getSimpleJdbcTemplate();
	SimpleJdbcInsert getSimpleJdbcInsert();
	
	Long totalRegistro(String tabela) throws Exception;
	
	Query obterQuery(String query) throws Exception;
	
	//carregamento dinamico
	List<T> findListByQueryDinamica(String query, int iniciaRegistro, int maximoResultado) throws Exception;
	
	
}
