import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class App {

	protected Shell shlFtpgateway;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			App window = new App();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlFtpgateway.open();
		shlFtpgateway.layout();
		while (!shlFtpgateway.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlFtpgateway = new Shell();
		shlFtpgateway.setSize(974, 187);
		shlFtpgateway.setText("FtpGateway");		
		
		Group grpLocal = new Group(shlFtpgateway, SWT.NONE);
		grpLocal.setText("Local");
		grpLocal.setToolTipText("");
		grpLocal.setBounds(10, 10, 290, 108);
		
		Label lblPath = new Label(grpLocal, SWT.NONE);
		lblPath.setBounds(12, 84, 55, 15);
		lblPath.setText("path");
		
		text = new Text(grpLocal, SWT.BORDER);
		text.setBounds(78, 78, 200, 21);
		
		Button btnGet = new Button(grpLocal, SWT.RADIO);
		btnGet.setBounds(10, 28, 90, 16);
		btnGet.setText("GET");
		
		Button btnPut = new Button(grpLocal, SWT.RADIO);
		btnPut.setBounds(10, 50, 90, 16);
		btnPut.setText("PUT");
		
		Group grpPasserelle = new Group(shlFtpgateway, SWT.NONE);
		grpPasserelle.setText("Gateway Host");
		grpPasserelle.setBounds(306, 10, 280, 108);
		
		Label lblIp = new Label(grpPasserelle, SWT.NONE);
		lblIp.setBounds(10, 21, 55, 15);
		lblIp.setText("ip");
		
		text_1 = new Text(grpPasserelle, SWT.BORDER);
		text_1.setBounds(71, 15, 100, 21);
		
		Label lblUser = new Label(grpPasserelle, SWT.NONE);
		lblUser.setBounds(10, 42, 55, 15);
		lblUser.setText("user");
		
		text_2 = new Text(grpPasserelle, SWT.BORDER);
		text_2.setBounds(71, 36, 100, 21);
		
		Label lblPwd = new Label(grpPasserelle, SWT.NONE);
		lblPwd.setBounds(10, 63, 55, 15);
		lblPwd.setText("pwd");
		
		text_3 = new Text(grpPasserelle, SWT.BORDER);
		text_3.setBounds(71, 57, 100, 21);
		
		Label lblPath_1 = new Label(grpPasserelle, SWT.NONE);
		lblPath_1.setBounds(10, 84, 55, 15);
		lblPath_1.setText("path");
		
		text_7 = new Text(grpPasserelle, SWT.BORDER);
		text_7.setBounds(71, 78, 200, 21);
		
		Group grpHost = new Group(shlFtpgateway, SWT.NONE);
		grpHost.setText("Host");
		grpHost.setBounds(592, 10, 280, 108);
		
		Label label = new Label(grpHost, SWT.NONE);
		label.setText("ip");
		label.setBounds(10, 21, 55, 15);
		
		text_4 = new Text(grpHost, SWT.BORDER);
		text_4.setBounds(71, 15, 100, 21);
		
		Label label_1 = new Label(grpHost, SWT.NONE);
		label_1.setText("user");
		label_1.setBounds(10, 42, 55, 15);
		
		text_5 = new Text(grpHost, SWT.BORDER);
		text_5.setBounds(71, 36, 100, 21);
		
		Label label_2 = new Label(grpHost, SWT.NONE);
		label_2.setText("pwd");
		label_2.setBounds(10, 63, 55, 15);
		
		text_6 = new Text(grpHost, SWT.BORDER);
		text_6.setBounds(71, 57, 100, 21);
		
		Label label_3 = new Label(grpHost, SWT.NONE);
		label_3.setText("path");
		label_3.setBounds(10, 84, 55, 15);
		
		text_8 = new Text(grpHost, SWT.BORDER);
		text_8.setBounds(71, 78, 200, 21);
		
		Button btnStart = new Button(shlFtpgateway, SWT.NONE);
		btnStart.setBounds(878, 56, 75, 25);
		btnStart.setText("START");
	}
}
