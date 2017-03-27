package du.tech.baccarat.web.action.bc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import du.tech.baccarat.domain.game.Game;
import du.tech.baccarat.domain.game.GameKey;
import du.tech.baccarat.domain.tabt.Tabt;
import du.tech.baccarat.utils.PageResponseBean;
import du.tech.baccarat.web.action.base.BaseAction;

public class GameAction extends BaseAction implements ModelDriven<Game> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game game;

	@Override
	public Game getModel() {
		if (game == null) {
			game = new Game();
		}
		return game;
	}

	public String saveOrUpdate() {
		int currGameSet = IGameSerivce.getCurrentGameSet();
		int currGameNo = IGameSerivce.getCurrentGameNo();
		game.setGameKey(new GameKey(currGameSet, currGameNo));
		IGameSerivce.saveToSession(game);
		if (tmpOrSave.equalsIgnoreCase("Y")) {
			IGameSerivce.saveOrUpDate();
		}

		return "saveOrUpdateSUCCESS";
	}

	public String fileUploading() {
		Game fileGame = new Game();

		HSSFWorkbook hssfWorkbook;
		try {
			hssfWorkbook = new HSSFWorkbook(new FileInputStream(uploadFile));
			HSSFSheet sheet = hssfWorkbook.getSheet("Sheet1");
			for (Row row : sheet) {
				double currValue = 0.0;
				int gameSet = 0;
				int gameNo = 0;
				if (row.getRowNum() == 0)
					continue;
				for (Cell cell : row) {
					currValue = cell.getNumericCellValue();
					if (cell.getColumnIndex() == 0) {
						gameSet = (int) currValue;
					}
					if (cell.getColumnIndex() == 1) {
						gameNo = (int) currValue;
						fileGame.setGameKey(new GameKey(gameSet, gameNo));
					}
					if (cell.getColumnIndex() == 2) {
						fileGame.setPamt(new BigDecimal(currValue));
					}
					if (cell.getColumnIndex() == 3) {
						fileGame.setBamt(new BigDecimal(currValue));
					}
					if (cell.getColumnIndex() == 4) {
						fileGame.setTamt(new BigDecimal(currValue));
						IGameSerivce.saveOrUpdateByFile(fileGame);
					}
				}
			}
			return "fileUploadingSUCCESS";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fileUploadingFAIL";

	}

	// ---------This part will be used in pagation, later will optimize

	public String processPagination() {
		if(isMutiCondition!=null && isMutiCondition.equalsIgnoreCase("Y"))
		{
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Game.class);
			detachedCriteria.createAlias("tabt", "t");
		    if(game.getPamt()!=null) detachedCriteria.add(Restrictions.eq("pamt", game.getPamt()));
		    if(game.getBamt()!=null) detachedCriteria.add(Restrictions.eq("bamt", game.getBamt()));
		    if(game.getTamt()!=null) detachedCriteria.add(Restrictions.eq("tamt", game.getTamt()));
		    if(game.getTabt().getDealerName()!=null) detachedCriteria.add(Restrictions.like("t.dealerName", "%" + game.getTabt().getDealerName() + "%"));
			return processPaginationParent(detachedCriteria);
		}
		else
		{
			return processPaginationParent(Game.class);
		}
	
	}

	public String getTabtList() {
		List<Tabt> listTables = IGameSerivce.findAllTabts();
		ActionContext.getContext().put("listTables", listTables);

		return "TABTLISTSUCCESS";
	}
	
	public String exportXls(){
		return "exportXlsSUCCESS";
	}
	
	public InputStream getInputStream() throws IOException{
		PageResponseBean pageResponseBean =(PageResponseBean) ServletActionContext.getRequest().getSession().getAttribute("pageResponseBean");
		
		List <Game> lGame = pageResponseBean.getRows();
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet sheet = hssfWorkbook.createSheet("Game History Infomation");
		HSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("Plyaer Amout");
		
		for (Game game:lGame){
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
			dataRow.createCell(0).setCellValue(game.getPamt().doubleValue());
		}
		
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		hssfWorkbook.write(arrayOutputStream);
		arrayOutputStream.close();
		byte[] data= arrayOutputStream.toByteArray();

		return new ByteArrayInputStream(data);
	}
	
	
	

	private String tmpOrSave;
	
	private String isMutiCondition;

	private File uploadFile;

	public String getTmpOrSave() {
		return tmpOrSave;
	}

	public void setTmpOrSave(String tmpOrSave) {
		this.tmpOrSave = tmpOrSave;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getIsMutiCondition() {
		return isMutiCondition;
	}

	public void setIsMutiCondition(String isMutiCondition) {
		this.isMutiCondition = isMutiCondition;
	}

}
