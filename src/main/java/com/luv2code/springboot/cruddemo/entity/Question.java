package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="question")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_q")
	@JsonIgnore
    private int qNum;
	
	@Column(name="cat_id")
    private int qCath;


	@Column(name="state")
    private String qText;
	@Column(name="proposition1")
    private String pro1;
	
	@Column(name="proposition2")
	private String pro2;
	
	@Column(name="proposition3")
	private String pro3;

	@Column(name="img")
    private String imgName;

	@Column(name="answer")
    private char validRep;

	@Column(name="justification")
    private String justif;

    public Question(){

    }
    
    public Question(Question q){
        this.qNum = q.qNum;
        this.qCath = q.qCath;
    }

    public String getqText() { return qText;}

    public void setqText(String qText) {this.qText = qText;}

    public int getqNum() {
        return qNum;
    }

    public void setqNum(int qNum) {
        this.qNum = qNum;
    }

    public int getqCath() {
        return qCath;
    }

    public void setqCath(int qCath) {
        this.qCath = qCath;
    }

    public String getPro1() {
    	String ch = new String(pro1);
        return ch;
    }

    public void setPro1(String pro1) {
        this.pro1 = pro1;
    }

    public String getPro2() {
        return pro2;
    }

    public void setPro2(String pro2) {
        this.pro2 = pro2;
    }

    public String getPro3() {
        return pro3;
    }

    public void setPro3(String pro3) {
        this.pro3 = pro3;
    }

    public char getValidRep() {
        return validRep;
    }

    public void setValidRep(char validRep) {this.validRep = validRep;}

    public String getJustif() {return justif;}

    public void setJustif(String justif) {this.justif = justif;}

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
    
    
	@Override
	public String toString() {
		return "Question [qNum=" + qNum + ", qCath=" + qCath + ", qText=" + qText + ", pro1=" + pro1 + ", pro2=" + pro2
				+ ", pro3=" + pro3 + ", imgName=" + imgName + ", validRep=" + validRep + ", justif=" + justif + "]";
	}
    
    
}
