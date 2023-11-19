package com.cg.mts.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "theatre")
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int theatreId;
	private String theatreName;
	private String theatreCity;
	private String managerName;
	private String managerContact;
	@OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Screen> screen;
	@JsonIgnore
	@OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
	private List<Show> show;


	public Theatre(String theatreName, String theatreCity, String managerName, String managerContact,
			List<Screen> screen, List<Show> show) {
		super();
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
		this.screen = screen;
		this.show = show;
	}
}
