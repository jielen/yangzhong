package com.ufgov.zc.client.zc.zcxmcght;

import java.util.List;

import com.ufgov.zc.client.common.BillElementMeta;
import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.ZcBaseBill;
import com.ufgov.zc.common.zc.model.ZcEbBulletinWordMold;

public abstract class AbstractZcXmcgHtEditPanel extends AbstractMainSubEditPanel{

  public AbstractZcXmcgHtEditPanel() {

  }

  public AbstractZcXmcgHtEditPanel(ZcBaseBill model, String compoId) {

    super(model, compoId);

  }

  public AbstractZcXmcgHtEditPanel(Class billClass, BillElementMeta eleMeta) {

    super(billClass, eleMeta);

  }

  public abstract String doOpenMold(List valueList, ZcEbBulletinWordMold bulletinMold);
  
  public abstract ElementConditionDto getDtoForBidWinner();
  
  public abstract ListCursor getListCursor();
  
  public abstract void zcMakeCodeChange();
  
  public abstract boolean isGys();

  public void setIsCar(boolean b) {
    // TCJLODO Auto-generated method stub
    
  }
  

  /**
   * 构建合同明细
   * 如果是非询价类的采购，则根据分包的需求明细构建
   * 如果是询价类的，根据询价单和报价单构建
   */
  public void buildHtDetail() {
    // TCJLODO Auto-generated method stub
    
  }
}
