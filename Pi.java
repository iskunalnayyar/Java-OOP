
/*
 * Pi.java
 * 
 * Versions
 * 		10/28/2017
 * 
 * Revisions
 * 		8.2
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;
import javax.imageio.ImageIO;

/**
 * Pi class will read the files and determine the even and odds counts and fill
 * the colors based on even or odd counts using JFrame.
 * 
 * Two THreads have been used to read the data from the input stream reader and
 * other thread used to fill the color
 * 
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 *
 */
public class Pi extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int LENGTH_OF_SQUARE = 3;
	private final int LENGTH = 330;
	private final int LENGTH_OF_WINDOW = LENGTH * LENGTH_OF_SQUARE;
	private static BufferedImage theImage;
	private LinkedBlockingQueue<Character> queue = new LinkedBlockingQueue<Character>();
	private String fileName = null;
	int red = Color.RED.getRGB();
	int blue = Color.BLUE.getRGB();
	Reader input;;

	/**
	 * Default Constructor. Just the read the hardcoded file Name
	 */
	public Pi() {
		super("Pi");
		setBounds(100, 100, LENGTH_OF_WINDOW, LENGTH_OF_WINDOW);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			input = new InputStreamReader(System.in);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Will the execute the default constructor and then read the file given by the
	 * user
	 * 
	 * @param fileName
	 */
	public Pi(String fileName) {
		this();
		this.fileName = fileName;
		try {
			input = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will the read the next character from the input buffer
	 * 
	 * @return next character
	 */
	public char nextDigit() {
		char buf[] = new char[1];
		try {
			input.read(buf);
			if (buf[0] == '.')
				input.read(buf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buf[0];
	}

	/**
	 * This method will write after the read the data and processed the data and
	 * store the image in the specified file name
	 * 
	 * @param theImage
	 */
	public void saveImage(BufferedImage theImage) {
		try {
			String suffix = fileName.substring(1 + fileName.lastIndexOf("."));
			File outputfile = new File(suffix + "_" + fileName);
			ImageIO.write(theImage, suffix, outputfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will read each cahracter from the input stream and fill the
	 * desired square with specified color based on odd or even character
	 * 
	 * @param xOrig
	 * @param yOrig
	 * @param color
	 */
	public void fillSquare(int xOrig, int yOrig, int color) {
		for (int x = 0; x < LENGTH_OF_SQUARE; x++)
			for (int y = 0; y < LENGTH_OF_SQUARE; y++)
				theImage.setRGB(xOrig + x, yOrig + y, color);
	}

	/**
	 * This method will target the coordinates and get each characters and processed
	 * the fill square
	 * 
	 * @throws InterruptedException
	 */
	public void createImage() throws InterruptedException {
		theImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < getHeight(); y += LENGTH_OF_SQUARE) {
			for (int x = 0; x < getWidth(); x += LENGTH_OF_SQUARE) {
				char digit = queue.take();
				fillSquare(x, y, digit % 2 == 0 ? red : blue);
			}

		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(theImage, 0, 0, this);
	}

	/**
	 * This method contains two thread one to get the character from the input
	 * stream and other to call the create image method simultaneously
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (Thread.currentThread().getName().equals("11")) {
			while (nextDigit() >= 48 && nextDigit() <= 57) {
				try {
					
					queue.put(nextDigit());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if (Thread.currentThread().getName().equals("12")) {
			try {
				createImage();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		String fileName = null;
		if (args.length == 1)
			fileName = args[0];
		else
			fileName = "data.txt";

		Pi aPi = new Pi(fileName);
		aPi.setVisible(true);

		Thread t0 = new Thread(aPi);
		Thread t1 = new Thread(aPi);

		t0.setName("11");
		t1.setName("12");
		t0.start();
		t1.start();
		t0.join();
		t1.join();

		aPi.repaint();
		aPi.saveImage(theImage);
		System.exit(0);
	}

}
