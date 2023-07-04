package com.cts.ecart.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity(name = "brands")
public class Brand {
	@Id
	@GeneratedValue
	private int brandId;
	private String brandTitle;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "brand_info", joinColumns = { @JoinColumn(name = "brandId") }, inverseJoinColumns = {
			@JoinColumn(name = "productId") })
	private List<Product> prodsBrands = new ArrayList<Product>();

	public List<Product> getProdsBrands() {
		return prodsBrands;
	}

	public void setProdsBrands(List<Product> prodsBrands) {
		this.prodsBrands = prodsBrands;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandTitle() {
		return brandTitle;
	}

	public void setBrandTitle(String brandTitle) {
		this.brandTitle = brandTitle;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandTitle=" + brandTitle + ", prodsBrands=" + prodsBrands + "]";
	}

}
