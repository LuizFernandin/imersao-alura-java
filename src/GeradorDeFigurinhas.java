import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage imgOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memoria com transparencia e com tamanho novo
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImg = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem(em memoria)
        Graphics2D graphics = (Graphics2D) novaImg.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        //configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("TPZERA", 150, novaAltura - 100);

        // escrever a nova imagem em um arquivo
        String path = "assets/" + nomeArquivo.replaceAll(":", "") + ".png";
        ImageIO.write(novaImg, "png", new File(path));

    }

}
