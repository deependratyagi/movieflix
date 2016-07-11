package com.egen.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class MovieList {
	
	@Id
private String list_imdbId;
private String list_title;
private String list_year;
private String list_rated;
private String list_released;
private String list_runtime;
private String list_genre;
private String list_director;
private String list_writer;
private String list_actors;
private String list_plot;
private String list_language;
private String list_country;
private String list_awards;
private String list_poster;
private String list_metascore;
private String list_imdbrating;
private String list_imdbvotes;
private String list_type;
private String list_avgrating;
private int list_countusers;

public String getList_imdbId() {
	return list_imdbId;
}
public void setList_imdbId(String list_imdbId) {
	this.list_imdbId = list_imdbId;
}
public String getList_title() {
	return list_title;
}
public void setList_title(String list_title) {
	this.list_title = list_title;
}
public String getList_year() {
	return list_year;
}
public void setList_year(String list_year) {
	this.list_year = list_year;
}
public String getList_rated() {
	return list_rated;
}
public void setList_rated(String list_rated) {
	this.list_rated = list_rated;
}
public String getList_released() {
	return list_released;
}
public void setList_released(String list_released) {
	this.list_released = list_released;
}
public String getList_runtime() {
	return list_runtime;
}
public void setList_runtime(String list_runtime) {
	this.list_runtime = list_runtime;
}
public String getList_genre() {
	return list_genre;
}
public void setList_genre(String list_genre) {
	this.list_genre = list_genre;
}
public String getList_director() {
	return list_director;
}
public void setList_director(String list_director) {
	this.list_director = list_director;
}
public String getList_writer() {
	return list_writer;
}
public void setList_writer(String list_writer) {
	this.list_writer = list_writer;
}
public String getList_actors() {
	return list_actors;
}
public void setList_actors(String list_actors) {
	this.list_actors = list_actors;
}
public String getList_plot() {
	return list_plot;
}
public void setList_plot(String list_plot) {
	this.list_plot = list_plot;
}
public String getList_language() {
	return list_language;
}
public void setList_language(String list_language) {
	this.list_language = list_language;
}
public String getList_country() {
	return list_country;
}
public void setList_country(String list_country) {
	this.list_country = list_country;
}
public String getList_awards() {
	return list_awards;
}
public void setList_awards(String list_awards) {
	this.list_awards = list_awards;
}
public String getList_poster() {
	return list_poster;
}
public void setList_poster(String list_poster) {
	this.list_poster = list_poster;
}
public String getList_metascore() {
	return list_metascore;
}
public void setList_metascore(String list_metascore) {
	this.list_metascore = list_metascore;
}
public String getList_imdbrating() {
	return list_imdbrating;
}
public void setList_imdbrating(String list_imdbrating) {
	this.list_imdbrating = list_imdbrating;
}
public String getList_imdbvotes() {
	return list_imdbvotes;
}
public void setList_imdbvotes(String list_imdbvotes) {
	this.list_imdbvotes = list_imdbvotes;
}
public String getList_type() {
	return list_type;
}
public void setList_type(String list_type) {
	this.list_type = list_type;
}
public String getList_avgrating() {
	return list_avgrating;
}
public void setList_avgrating(String list_avgrating) {
	this.list_avgrating = list_avgrating;
}
public int getList_countusers() {
	return list_countusers;
}
public void setList_countusers(int list_countusers) {
	this.list_countusers = list_countusers;
}
}
