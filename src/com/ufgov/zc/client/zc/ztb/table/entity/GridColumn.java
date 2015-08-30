package com.ufgov.zc.client.zc.ztb.table.entity;import java.io.Serializable;import java.util.ArrayList;import java.util.List;import java.util.Map;public class GridColumn implements Serializable {  public final static String PAGE_ID = "PAGE_ID";  public final static String GRID_ID = "GRID_ID";  public final static String COLUMN_ID = "COLUMN_ID";  public final static String ORD_INDEX = "ORD_INDEX";  public final static String CAPTION = "CAPTION";  public final static String WIDTH = "WIDTH";  public final static String IS_VISIBLE = "IS_VISIBLE";  public final static String ALIGN = "ALIGN";  public final static String DATA_TYPE = "DATA_TYPE";  public final static String VALSET_ID = "VALSET_ID";  public final static String ROW_INDEX = "ROW_INDEX";  public final static String COL_INDEX = "COL_INDEX";  public final static String FIELD_WIDTH = "FIELD_WIDTH";  public final static String FIELD_HEIGHT = "FIELD_HEIGHT";  public final static String IS_READONLY = "IS_READONLY";  public final static String IS_NULL = "IS_NULL";  public final static String IS_ALLOW_INPUT = "IS_ALLOW_INPUT";  public final static String MIN_VALUE = "MIN_VALUE";  public final static String MAX_VALUE = "MAX_VALUE";  public final static String MIN_LEN = "MIN_LEN";  public final static String MAX_LEN = "MAX_LEN";  public final static String IS_IN_EDITOR = "IS_IN_EDITOR";  public final static String EDITOR_TYPE = "EDITOR_TYPE";  public final static String EDITOR_TYPE_TEXTFIELD = "EDITOR_TYPE_TEXTFIELD";  public final static String EDITOR_TYPE_COMBOBOX = "EDITOR_TYPE_COMBOBOX";  public final static String EDITOR_TYPE_DATEFIELD = "EDITOR_TYPE_DATEFIELD";  public final static String EDITOR_TYPE_CHECKBOX = "EDITOR_TYPE_CHECKBOX";  public final static String EDITOR_TYPE_RADIOBUTTON = "EDITOR_TYPE_RADIOBUTTON";  public final static String IS_SAVE = "IS_SAVE";  public final static String IS_PK = "IS_PK";  public final static String DEC_LEN = "DEC_LEN";  public final static String DATA_TYPE_NUM = "NUM";  public final static String DATA_TYPE_TEXT = "TEXT";  public final static String DATA_TYPE_DATE = "DATE";  public final static String ALIGN_LEFT = "L";  public final static String ALIGN_RIGHT = "R";  public final static String ALIGN_CENTER = "C";  public final static String IS_IN_TABLE = "IS_IN_TABLE";  public final static String DEFAULT_VALUE = "DEFAULT_VALUE";  public final static String IS_AUTO_NUM = "IS_AUTO_NUM";  public final static String IS_FORCE_READONLY = "IS_FORCE_READONLY";  public final static String REMARK = "REMARK";  public final static String COLUMN_POSITION = "COLUMN_POSITION";  public final static String COLUMN_POSITION_LEFT = "L";  public final static String COLUMN_POSITION_RIGHT = "R";  public final static String IS_WATCH_ONLY = "IS_WATCH_ONLY";  public final static String IS_SHOW_ZERO = "IS_SHOW_ZERO";  public final static String IS_THOUSANDS_SEPARATOR = "IS_THOUSANDS_SEPARATOR";  public final static String CHECKBOX = "CHECKBOX";  public static final String GROUP_ID = "GROUP_ID";  private String pageId;  private String gridId;  private String columnId;  private int ordIndex;  private String caption;  private int width = 100;  private boolean isVisible = true;  private String align;  private String dataType;  private String valsetId;  private int rowIndex;  private int colIndex;  private int fieldWidth;  private int fieldHeight;  private boolean isReadOnly = false;  private boolean isNull;  private boolean isAllowInput;  private double minValue;  private double maxValue;  private int minLen;  private int maxLen;  private int decLen;  private boolean isInEditor;  private String editorType;  private boolean isSave;  private boolean isPk;  private List valsetList;  private Map valsetMap;  private boolean isInTable = true;  private String defaultValue;  private boolean isAutoNum;  private boolean isForceReadOnly;  private String remark;  private String columnPosition;  private boolean isWatchOnly = false;  private boolean isShowZero;  private boolean isPrint = true;  private boolean isThousandsSeparator = true;  private String numberFormatString;  private String groupId;  //private boolean isSumaryCol = false;  private Map dataMap;  public GridColumn() {  }  public GridColumn(String pageId, String gridId) {    this.pageId = pageId;    this.gridId = gridId;  }  public void setPageId(String pageId) {    this.pageId = pageId;  }  public String getPageId() {    return pageId;  }  public void setGridId(String gridId) {    this.gridId = gridId;  }  public String getGridId() {    return gridId;  }  public void setColumnId(String columnId) {    this.columnId = columnId;  }  public String getColumnId() {    return columnId;  }  public void setOrdIndex(int ordIndex) {    this.ordIndex = ordIndex;  }  public int getOrdIndex() {    return ordIndex;  }  public void setCaption(String caption) {    this.caption = caption;  }  public String getCaption() {    return caption;  }  public void setWidth(int width) {    this.width = width;  }  public int getWidth() {    return width;  }  public void setVisible(boolean isVisible) {    this.isVisible = isVisible;  }  public boolean isVisible() {    return isVisible;  }  public String getAlign() {    return align;  }  public void setAlign(String align) {    this.align = align;  }  public String getDataType() {    return dataType;  }  public void setDataType(String dataType) {    this.dataType = dataType;  }  public String getValsetId() {    return valsetId;  }  public void setValsetId(String valsetId) {    this.valsetId = valsetId;  }  public int getRowIndex() {    return rowIndex;  }  public void setRowIndex(int rowIndex) {    this.rowIndex = rowIndex;  }  public int getColIndex() {    return colIndex;  }  public void setColIndex(int colIndex) {    this.colIndex = colIndex;  }  public int getFieldWidth() {    return fieldWidth;  }  public void setFieldWidth(int fieldWidth) {    this.fieldWidth = fieldWidth;  }  public int getFieldHeight() {    return fieldHeight;  }  public void setFieldHeight(int fieldHeight) {    this.fieldHeight = fieldHeight;  }  public boolean isReadOnly() {    return isReadOnly;  }  public void setReadOnly(boolean isReadOnly) {    this.isReadOnly = isReadOnly;  }  public boolean isNull() {    return isNull;  }  public void setNull(boolean isNull) {    this.isNull = isNull;  }  public boolean isAllowInput() {    return isAllowInput;  }  public void setAllowInput(boolean isAllowInput) {    this.isAllowInput = isAllowInput;  }  public double getMinValue() {    return minValue;  }  public void setMinValue(double minValue) {    this.minValue = minValue;  }  public double getMaxValue() {    return maxValue;  }  public void setMaxValue(double maxValue) {    this.maxValue = maxValue;  }  public int getMinLen() {    return minLen;  }  public void setMinLen(int minLen) {    this.minLen = minLen;  }  public int getMaxLen() {    return maxLen;  }  public void setMaxLen(int maxLen) {    this.maxLen = maxLen;  }  public void setInEditor(boolean isInEditor) {    this.isInEditor = isInEditor;  }  public boolean isInEditor() {    return isInEditor;  }  public void setEditorType(String editorType) {    this.editorType = editorType;  }  public String getEditorType() {    return editorType;  }  public void setValsetList(List valsetList) {    this.valsetList = valsetList;  }  public List getValsetList() {    if (valsetList == null)      valsetList = new ArrayList();    return valsetList;  }  public void setValsetMap(Map valsetMap) {    this.valsetMap = valsetMap;  }  public Map getValsetMap() {    return valsetMap;  }  public boolean isComboBox() {    return getValsetId() != null && getValsetId().trim().length() > 0;  }  public boolean isText() {    return DATA_TYPE_TEXT.equalsIgnoreCase(this.getDataType());  }  public boolean isNumber() {    return DATA_TYPE_NUM.equalsIgnoreCase(this.getDataType());  }  public void setSave(boolean isSave) {    this.isSave = isSave;  }  public boolean isSave() {    return isSave;  }  public void setPk(boolean isPk) {    this.isPk = isPk;  }  public boolean isPk() {    return isPk;  }  public void setDecLen(int decLen) {    this.decLen = decLen;  }  public int getDecLen() {    return decLen;  }  public boolean getReadOnly() {    return isReadOnly;  }  public boolean isCheckBox() {    return EDITOR_TYPE_CHECKBOX.equalsIgnoreCase(getEditorType());  }  public boolean isRadioButton() {    return EDITOR_TYPE_RADIOBUTTON.equalsIgnoreCase(getEditorType());  }  public void setInTable(boolean isInTable) {    this.isInTable = isInTable;  }  public boolean isInTable() {    return isInTable;  }  public void setDefaultValue(String defaultValue) {    this.defaultValue = defaultValue;  }  public String getDefaultValue() {    return defaultValue;  }  public boolean isInteger() {    if (isNumber() && getDecLen() == 0) {      return true;    }    return false;  }  public boolean isAutoNum() {    return isAutoNum;  }  public void setAutoNum(boolean isAutoNum) {    this.isAutoNum = isAutoNum;  }  public boolean isFloat() {    if (isNumber() && getDecLen() > 0) {      return true;    }    return false;  }  public void setForceReadOnly(boolean isForceReadOnly) {    this.isForceReadOnly = isForceReadOnly;  }  public boolean isForceReadOnly() {    return isForceReadOnly;  }  public boolean isDate() {    return DATA_TYPE_DATE.equals(getDataType());  }  public void setRemark(String remark) {    this.remark = remark;  }  public String getRemark() {    return remark;  }  public void setColumnPosition(String columnPosition) {    this.columnPosition = columnPosition;  }  public String getColumnPosition() {    return columnPosition;  }  public boolean isColumnPositionRight() {    if (COLUMN_POSITION_RIGHT.equalsIgnoreCase(getColumnPosition())) {      return true;    }    return false;  }  public void setWatchOnly(boolean isWatchOnly) {    this.isWatchOnly = isWatchOnly;  }  public boolean isWatchOnly() {    return isWatchOnly;  }  public void setShowZero(boolean isShowZero) {    this.isShowZero = isShowZero;  }  public boolean isShowZero() {    return isShowZero;  }  public void setPrint(boolean isPrint) {    this.isPrint = isPrint;  }  public boolean isPrint() {    return isPrint;  }  public void setThousandsSeparator(boolean isThousandsSeparator) {    this.isThousandsSeparator = isThousandsSeparator;  }  public boolean isThousandsSeparator() {    return isThousandsSeparator;  }  public void setNumberFormatString(String numberFormatString) {    this.numberFormatString = numberFormatString;  }  public String getNumberFormatString() {    return numberFormatString;  }  public boolean isTableHeaderCheckBox() {    return CHECKBOX.equalsIgnoreCase(getCaption());  }  public void createNumberFormatString() {    StringBuffer stringBuffer = new StringBuffer();    if (isThousandsSeparator()) {      stringBuffer.append("#,##0.");    } else {      stringBuffer.append("###0.");    }    for (int i = 0, j = getDecLen(); i < j; i++) {      stringBuffer.append("0");    }    setNumberFormatString(stringBuffer.toString());  }  public String getGroupId() {    return groupId;  }  public void setGroupId(String groupId) {    this.groupId = groupId;  }  public boolean isTableRowNum() {    return columnId.equalsIgnoreCase("TABLE.ROWNUM");  }  //  public boolean isSumaryCol() {  //    return isSumaryCol;  //  }  //  //  public void setSumaryCol(boolean isSumaryCol) {  //    this.isSumaryCol = isSumaryCol;  //  }  public void setDataMap(Map dataMap) {    this.dataMap = dataMap;  }  public Map getDataMap() {    return dataMap;  }}