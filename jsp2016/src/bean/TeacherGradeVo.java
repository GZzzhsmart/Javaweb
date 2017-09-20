package bean;

import java.io.Serializable;

public class TeacherGradeVo implements Serializable{
	private int gradeId;
	private String gradeName;
	private float gradePercent;
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public float getGradePercent() {
		return gradePercent;
	}
	public void setGradePercent(float gradePercent) {
		this.gradePercent = gradePercent;
	}
}
