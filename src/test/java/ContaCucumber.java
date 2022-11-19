import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContaCucumber {
	public int saldo01, saldo02, saque, clienteComum;
	public boolean clienteEspecial;

	/**
	 * 
	 * @param int1 Cliente especial está com saldo negativo
	 */

	@Given("um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
		this.clienteEspecial = false;
		this.saldo01 = int1;
		if (this.saldo01 != int1)
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * 
	 * @param int1 Cliente especial solicita saque
	 */
	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int1) {
		this.saque = int1;
		if (this.saque != int1)
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * 
	 * @param int1 Após efetuar o saque deve atualizar o saldo
	 */

	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int1) {
		int1 = this.saldo01 - (saque);

		if (this.clienteEspecial = true && int1 < 0) {
			this.saldo02 = int1;
		} else {
			throw new io.cucumber.java.PendingException();
		}
	}

	/**
	 * 
	 * @param int1 Cliente comum com saldo negativo
	 */

	@Given("um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
		this.clienteComum = int1;
		this.clienteEspecial = false;
		if (this.clienteComum != int1)
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * 
	 * @param int1 Cliente comum solicita saque
	 */

	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int1) {
		this.saque = int1;
		if (this.saque != int1)
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * @param Deve informar que o saldo é insuficiente para efetuar o saque
	 */

	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		if (this.clienteComum < 0 || this.saque > this.clienteComum) {
			System.out.println("Saldo Insuficiente");
		} else if (this.saque < this.clienteComum) {
			System.out.println("Saque Realizado com sucesso");

		} else {
			throw new io.cucumber.java.PendingException();
		}

	}
}
