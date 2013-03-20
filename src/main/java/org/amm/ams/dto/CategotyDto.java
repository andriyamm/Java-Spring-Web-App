package org.amm.ams.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CategotyDto {

	private Long id;
	private String name;
	private String langPrefix;
	private List<CategotyDto> categotyDtos;

	public CategotyDto() {
		super();
	}

	public CategotyDto(Long id, String name, String langPrefix,
			List<CategotyDto> categoryDtos) {
		super();
		this.id = id;
		this.name = name;
		this.langPrefix = langPrefix;
		this.categotyDtos = categoryDtos;
	}

	public void addCategotyDto(CategotyDto categotyDto) {
		if (categotyDtos == null) {
			categotyDtos = new ArrayList<CategotyDto>();
		}
		categotyDtos.add(categotyDto);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLangPrefix() {
		return langPrefix;
	}

	public void setLangPrefix(String langPrefix) {
		this.langPrefix = langPrefix;
	}

	public List<CategotyDto> getCategotyDtos() {
		return categotyDtos;
	}

	public void setCategotyDtos(List<CategotyDto> categotyDtos) {
		this.categotyDtos = categotyDtos;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(name)
				.append(langPrefix).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		CategotyDto rhs = (CategotyDto) obj;
		return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name)
				.append(langPrefix, rhs.langPrefix).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name)
				.append("langPrefix", langPrefix).toString();
	}
}
