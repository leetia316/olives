package com.jeefw.model.sys;

import com.google.common.base.Objects;
import com.jeefw.model.sys.param.BannerParameter;
import com.jeefw.model.sys.param.RoleParameter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Set;

/**
 * 角色的实体类
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
@Entity
@Table(name = "banner")
@Cache(region = "all", usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount", "sortColumns", "cmd", "queryDynamicConditions", "sortedConditions", "dynamicProperties", "success", "message", "sortColumnsString", "flag" })
public class Banner extends BannerParameter {

	// 各个字段的含义请查阅文档的数据库结构部分
	private static final long serialVersionUID = 6019103858711599150L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "bannerSort")
	private Long bannerSort;
	@Column(name = "bannerName", length = 40, nullable = false, unique = true)
	private String bannerName;
	@Column(name = "bannerUrl", length = 400, nullable = false)
	private String bannerUrl;
	@Column(name = "bannerMemo", length = 200)
	private String bannerMemo;


	public Banner() {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Banner)) return false;

		Banner banner = (Banner) o;

		if (getId() != null ? !getId().equals(banner.getId()) : banner.getId() != null)
			return false;
		if (getBannerSort() != null ? !getBannerSort().equals(banner.getBannerSort()) : banner.getBannerSort() != null)
			return false;
		if (getBannerName() != null ? !getBannerName().equals(banner.getBannerName()) : banner.getBannerName() != null)
			return false;
		if (getBannerUrl() != null ? !getBannerUrl().equals(banner.getBannerUrl()) : banner.getBannerUrl() != null)
			return false;
		return !(getBannerMemo() != null ? !getBannerMemo().equals(banner.getBannerMemo()) : banner.getBannerMemo() != null);

	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getBannerSort() != null ? getBannerSort().hashCode() : 0);
		result = 31 * result + (getBannerName() != null ? getBannerName().hashCode() : 0);
		result = 31 * result + (getBannerUrl() != null ? getBannerUrl().hashCode() : 0);
		result = 31 * result + (getBannerMemo() != null ? getBannerMemo().hashCode() : 0);
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

	public Long getBannerSort() {
		return bannerSort;
	}

	public void setBannerSort(Long bannerSort) {
		this.bannerSort = bannerSort;
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}

	public String getBannerMemo() {
		return bannerMemo;
	}

	public void setBannerMemo(String bannerMemo) {
		this.bannerMemo = bannerMemo;
	}
}
