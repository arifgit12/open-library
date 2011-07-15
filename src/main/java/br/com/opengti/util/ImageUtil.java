package br.com.opengti.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import javax.imageio.ImageIO;

import br.com.opengti.domain.BookImage;



public class ImageUtil {

	public static String saveImage(BookImage bookImage) {

		String fileName = generateFileName(bookImage);

		try {

			File file = new File(ContextUtil.getRealPath("imageBook") + "/"
					+ fileName);

			InputStream in = new ByteArrayInputStream(bookImage.getData());
			BufferedImage img = javax.imageio.ImageIO.read(in);

			img = autoRecortarImagem(img);

			BufferedImage imgNew = new BufferedImage(170, 215,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D grapImg = imgNew.createGraphics();
			grapImg.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			AffineTransform xform = AffineTransform.getScaleInstance(
					(double) 170 / img.getWidth(), (double) 215
							/ img.getHeight());
			grapImg.drawRenderedImage(img, xform);
			grapImg.dispose();
			
			

			ImageIO.write(imgNew, "JPG", file);

			return fileName;
		} catch (IOException e) {
			return null;
		}
	}

	private static String generateFileName(BookImage bookImage) {
		Long timeinmillis = Calendar.getInstance().getTimeInMillis();
		String name = timeinmillis.toString();
		System.out.println(bookImage.getName());
		name = name
				+ bookImage.getName().substring(
						bookImage.getName().indexOf("."));

		return name;
	}

	private static BufferedImage autoRecortarImagem(BufferedImage bi) {

		int w = bi.getWidth();
		int h = bi.getHeight();
		int RGB = 0;
		int upperLeftX = 0;
		int upperLeftY = 0;
		int bottonX = 0;
		int bottonY = 0;
		for (int posY = 0; posY < h; posY++) {
			for (int posX = 0; posX < w; posX++) {
				RGB = bi.getRGB(posX, posY);
				Color color = new Color(RGB);

				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				// if(red != 0 && green != 0 && blue != 0){
				if (red < 240 && green < 240 && blue < 240) {
					if (upperLeftX == 0 || upperLeftX > posX) {
						upperLeftX = posX;
					}
					if (upperLeftY == 0 || upperLeftY > posY) {
						upperLeftY = posY;
					}
					if (bottonX <= w && bottonX < posX) {
						bottonX = posX;
					}
					if (bottonY <= h && bottonY < posY) {
						bottonY = posY;
					}
				}
				// }

			}
		}

		int newX = upperLeftX;
		int newY = upperLeftY;
		int newWidth = bottonX - upperLeftX;
		int newHeight = bottonY - upperLeftY;

		BufferedImage cropedBi = bi
				.getSubimage(newX, newY, newWidth, newHeight);

		return cropedBi;
	}

}
