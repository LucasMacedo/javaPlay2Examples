package exemplo1;
//Importa��o do Java
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
//Importa��o do javaPlay
import javaPlay.GameEngine;
import javaPlay.GameStateController;
import javaPlay.Keyboard;

/**
 * Executa as opera��es essenciais de um jogo como inicializa��o, rodada e desenho
 * para a fase 1.
 */
public class Fase1Controle implements GameStateController
{   
    Bola jogador;

	// Carrega todos os objetos e recursos que ser�o necess�rios para o jogo
    public void load() {
		this.jogador = new Bola();
	}

	//M�todo executado a cada itera��o do jogo.
    public void step(long timeElapsed) {
		
		Keyboard k = GameEngine.getInstance().getKeyboard();
		if(k.keyDown(Keyboard.RIGHT_KEY)){
			jogador.aumentaVelocidadeHorizontal();			
		}
		if(k.keyDown(Keyboard.LEFT_KEY)){
			jogador.diminuiVelocidadeHorizontal();
		}
		if(k.keyDown(Keyboard.SPACE_KEY)){
			jogador.mudaCor();
		}
		if(k.keyDown(KeyEvent.VK_P)){
			jogador.para();
		}
		
        jogador.step(timeElapsed);
    }

	//Realiza o desenho desta fase e dos seus respectivos objetos.
    public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 600);

		jogador.draw(g);
	}

	//Para refer�ncia sobre os m�todos abaixo consulte o ap�ndice D do livro.

    public void unload(){}
    public void start(){}
    public void stop(){ }
 
}
