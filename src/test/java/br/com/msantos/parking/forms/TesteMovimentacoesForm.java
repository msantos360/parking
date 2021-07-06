package br.com.msantos.parking.forms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.repository.ClienteRepository;
import br.com.msantos.parking.repository.EstacionamentoRepository;
import br.com.msantos.parking.repository.MovimentacoesRepository;
import br.com.msantos.parking.repository.VeiculoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesteMovimentacoesForm {

	@Autowired
	private MovimentacoesRepository movimentacoesRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;

	@Test
	public void testeCadastroMovimentacoesPeloMovimentacoesFormSemPagamentoId() {
		MovimentacoesForm movimentacoesForm = new MovimentacoesForm();

		movimentacoesForm.setPlaca("JHU-7458");

		Movimentacoes movimentacoes = movimentacoesForm.conterter(movimentacoesForm, clienteRepository,
				veiculoRepository, estacionamentoRepository);

		movimentacoesRepository.save(movimentacoes);

	}
	
	@Test
	public void teste() {
		
		String senha = "123";
		
		String hashpw = BCrypt.hashpw(senha, BCrypt.gensalt());
		
		System.out.println(hashpw);
	}

}
