package com.jeefw.model.frame;

import com.jeefw.model.frame.param.OlivesGroupParameter;
import com.jeefw.model.sys.param.BannerParameter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * 角色的实体类
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
@Entity
@Table(name = "olivesgroup")
@Cache(region = "all", usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount", "sortColumns", "cmd", "queryDynamicConditions", "sortedConditions", "dynamicProperties", "success", "message", "sortColumnsString", "flag" })
public class OlivesGroup extends OlivesGroupParameter {

	// 各个字段的含义请查阅文档的数据库结构部分
	private static final long serialVersionUID = 6019103858711599150L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "groupName",length = 40, nullable = false, unique = true)
	private String groupName;

	@Column(name = "groupType", length = 40, nullable = false, unique = true)
	private String groupType;
	@Column(name = "groupSize")
	private Integer  groupSize=0;
	@Column(name = "groupAttention")
	private Integer  groupAttention=0;
	@Column(name = "groupSort")
	private Integer  groupSort;
	@Column(name = "groupImg")
	private String groupImg;
	@Column(name = "groupMemo")
	private String groupMemo;


	@Column(name = "groupDate")
	private String groupDate;

	public String getGroupDate() {
		return groupDate;
	}

	public void setGroupDate(String groupDate) {
		this.groupDate = groupDate;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	public String getGroupType() {
		return groupType;
	}



	public OlivesGroup() {

	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OlivesGroup)) return false;

		OlivesGroup that = (OlivesGroup) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
		if (groupType != null ? !groupType.equals(that.groupType) : that.groupType != null) return false;
		if (groupSize != null ? !groupSize.equals(that.groupSize) : that.groupSize != null) return false;
		if (groupAttention != null ? !groupAttention.equals(that.groupAttention) : that.groupAttention != null)
			return false;
		if (groupSort != null ? !groupSort.equals(that.groupSort) : that.groupSort != null) return false;
		if (groupImg != null ? !groupImg.equals(that.groupImg) : that.groupImg != null) return false;
		return !(groupMemo != null ? !groupMemo.equals(that.groupMemo) : that.groupMemo != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
		result = 31 * result + (groupType != null ? groupType.hashCode() : 0);
		result = 31 * result + (groupSize != null ? groupSize.hashCode() : 0);
		result = 31 * result + (groupAttention != null ? groupAttention.hashCode() : 0);
		result = 31 * result + (groupSort != null ? groupSort.hashCode() : 0);
		result = 31 * result + (groupImg != null ? groupImg.hashCode() : 0);
		result = 31 * result + (groupMemo != null ? groupMemo.hashCode() : 0);
		return result;
	}

	public static long getSerialVersionUID() {

		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public Integer getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(Integer groupSize) {
		this.groupSize = groupSize;
	}

	public Integer getGroupAttention() {
		return groupAttention;
	}

	public void setGroupAttention(Integer groupAttention) {
		this.groupAttention = groupAttention;
	}

	public Integer getGroupSort() {
		return groupSort;
	}

	public void setGroupSort(Integer groupSort) {
		this.groupSort = groupSort;
	}

	public String getGroupImg() {
		return groupImg;
	}

	public void setGroupImg(String groupImg) {
		this.groupImg = groupImg;
	}

	public String getGroupMemo() {
		return groupMemo;
	}

	public void setGroupMemo(String groupMemo) {
		this.groupMemo = groupMemo;
	}
}
