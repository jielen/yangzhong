/**   * @(#) project: TableProject* @(#) file: XmlTableRow.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.server.zc.web.ylbTable.entity;import java.io.Serializable;import java.util.List;/*** @ClassName: XmlTableRow* @Description: TODO(这里用一句话描述这个类的作用)* @date: 2010-4-27 下午01:59:08* @version: V1.0 * @since: 1.0* @author: Administrator* @modify: */public class XmlTableRow implements Serializable {  private List cells;  public List getCells() {    return cells;  }  public void setCells(List cells) {    this.cells = cells;  }}