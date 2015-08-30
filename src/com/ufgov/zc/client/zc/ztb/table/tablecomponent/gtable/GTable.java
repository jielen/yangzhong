/** * @(#) project: TableProject * @(#) file: GTable.java * * Copyright 2010 UFGOV, Inc. All rights reserved. * UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. * */package com.ufgov.zc.client.zc.ztb.table.tablecomponent.gtable;import com.ufgov.zc.client.zc.ztb.table.entity.GridColumn;import com.ufgov.zc.client.zc.ztb.table.entity.GridColumnGroup;import com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTableColumnModel;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;/** * @ClassName: GTable * @Description: TODO(这里用一句话描述这个类的作用) * @date: 2010-4-23 下午02:08:45 * @version: V1.0 * @since: 1.0 * @author: Administrator * @modify: */public class GTable extends com.ufgov.zc.client.zc.ztb.table.tablecomponent.JTable {  private int groupLevel;  private int headerOneRowHeight = 26;  private List<Map<String, String>> gridColumnGroupData;  public GTable() {    super();  }  public void buildGroupTableHeader(List<Map<String, String>> gridColumnGroupData) {    this.gridColumnGroupData = gridColumnGroupData;    List<GridColumnGroup> groups = createGroupTableHeaderCellGroups();    groupLevel = getGTableGroupLevel(groups);    GTableHeader tableHeader = new GTableHeader(getColumnModel(), groupLevel, headerOneRowHeight);    setTableHeader(tableHeader);    setTableHeaderGroup(tableHeader);  }  public void setTableHeaderGroup(GTableHeader tableHeader) {    List<GridColumnGroup> groupTableHeaderCellGroups = createGroupTableHeaderCellGroups();    Map<String, GTableHeaderColumnGroup> gTableHeaderColumnGroups = createGTableHeaderColumnGroups(groupTableHeaderCellGroups, headerOneRowHeight);    List<GridColumn> groupTableHeaderCellMetas = ((JTableColumnModel) getColumnModel()).getGridColumns();    for (GridColumn groupTableHeaderCellMeta : groupTableHeaderCellMetas) {      String groupId = groupTableHeaderCellMeta.getGroupId();      if (groupId == null || groupId.trim().length() == 0) {        continue;      }      GTableHeaderColumnGroup group = gTableHeaderColumnGroups.get(groupId);      group.add(getColumnModel().getColumn(getColumnModel().getColumnIndex(groupTableHeaderCellMeta.getColumnId())));    }    for (GridColumnGroup gTableHdColumnGroupMeta : groupTableHeaderCellGroups) {      String groupId = gTableHdColumnGroupMeta.getGroupId();      String parentGroupId = gTableHdColumnGroupMeta.getParentGroupId();      int i = 0;      while (i++ < 10) {        GTableHeaderColumnGroup group = gTableHeaderColumnGroups.get(groupId);        if (parentGroupId == null || parentGroupId.trim().length() == 0) {          tableHeader.addColumnGroup(group);          break;        }        GTableHeaderColumnGroup parentGroup = gTableHeaderColumnGroups.get(parentGroupId);        if (parentGroup == null) {          tableHeader.addColumnGroup(group);          break;        }        parentGroup.add(group);        GridColumnGroup gTableHdColumnGroupMeta1 = findGTableHdColumnGroupMeta(groupTableHeaderCellGroups, parentGroupId);        if (gTableHdColumnGroupMeta1 == null) {          tableHeader.addColumnGroup(parentGroup);          break;        }        groupId = gTableHdColumnGroupMeta1.getGroupId();        parentGroupId = gTableHdColumnGroupMeta1.getParentGroupId();      }    }  }  public Map<String, GTableHeaderColumnGroup> createGTableHeaderColumnGroups(List<GridColumnGroup> groupTableHeaderCellGroups, int headerOneRowHeight) {    Map<String, GTableHeaderColumnGroup> gTableHeaderColumnGroups = new HashMap<String, GTableHeaderColumnGroup>();    for (GridColumnGroup gTableHdColumnGroupMeta : groupTableHeaderCellGroups) {      GTableHeaderColumnGroup gTableHeaderColumnGroup = new GTableHeaderColumnGroup(gTableHdColumnGroupMeta.getGroupName(), headerOneRowHeight);      gTableHeaderColumnGroups.put(gTableHdColumnGroupMeta.getGroupId(), gTableHeaderColumnGroup);    }    return gTableHeaderColumnGroups;  }  public List<GridColumnGroup> createGroupTableHeaderCellGroups() {    List<GridColumnGroup> groups = new ArrayList<GridColumnGroup>();    for (Map<String, String> rowMap : this.gridColumnGroupData) {      groups.add(createGridColumnGroup(rowMap));    }    return groups;  }  public GridColumnGroup createGridColumnGroup(Map<String, String> rowMap) {    GridColumnGroup groupTableHeaderCellGroup = new GridColumnGroup();    groupTableHeaderCellGroup.setGroupId(rowMap.get("GROUP_ID"));    groupTableHeaderCellGroup.setGroupName(rowMap.get("GROUP_NAME"));    groupTableHeaderCellGroup.setParentGroupId(rowMap.get("PARENT_GROUP_ID"));    return groupTableHeaderCellGroup;  }  public int getGTableGroupLevel(List<GridColumnGroup> groupTableHeaderCellGroups) {    int groupLevel = 0;    for (GridColumnGroup gTableHdColumnGroupMeta : groupTableHeaderCellGroups) {      String parentGroupId = gTableHdColumnGroupMeta.getParentGroupId();      int i = 0;      while (i++ < 10) {        if (parentGroupId == null || parentGroupId.trim().length() == 0) {          break;        }        GridColumnGroup gTableHdColumnGroupMeta1 = findGTableHdColumnGroupMeta(groupTableHeaderCellGroups, parentGroupId);        if (gTableHdColumnGroupMeta1 == null) {          break;        }        parentGroupId = gTableHdColumnGroupMeta1.getParentGroupId();      }      if (i > groupLevel) {        groupLevel = i;      }    }    return groupLevel + 1;  }  public GridColumnGroup findGTableHdColumnGroupMeta(List<GridColumnGroup> groupTableHeaderCellGroups, String groupId) {    for (GridColumnGroup gTableHdColumnGroupMeta : groupTableHeaderCellGroups) {      if (gTableHdColumnGroupMeta.getGroupId().equalsIgnoreCase(groupId)) {        return gTableHdColumnGroupMeta;      }    }    return null;  }}