package com.eliteams.quick4j.bean;

public class Permission {

	private Long permissionId;

	private String permissionName;

	private String permissionSign;

	private String permissionDesc;

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionSign() {
		return permissionSign;
	}

	public void setPermissionSign(String permissionSign) {
		this.permissionSign = permissionSign;
	}

	public String getPermissionDesc() {
		return permissionDesc;
	}

	public void setPermissionDesc(String permissionDesc) {
		this.permissionDesc = permissionDesc;
	}
}