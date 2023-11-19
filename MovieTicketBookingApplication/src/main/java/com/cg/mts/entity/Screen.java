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
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int screenId;
	@JsonIgnore
	@ManyToOne
	private Theatre theatre;
	@OneToMany(mappedBy = "screen",cascade = CascadeType.ALL)
	private List<Show> show;
	private String screenName;
	@Column(name = "rowss")
	private int rows;
	@Column(name = "columnss")
	private int columns;

	public Screen(Theatre theatre, List<Show> show, String screenName, int rows, int columns) {
		super();
		this.theatre = theatre;
		this.show = show;
		this.screenName = screenName;
		this.rows = rows;
		this.columns = columns;
	}

}
