package blacksmith.sullivanwayserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import blacksmith.sullivanwayserver.model.Congestion.PK;

@Entity(name = "congestion")
@IdClass(PK.class)
public class Congestion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -870899329100012880L;

	@Id
    @Column(name = "stn_id", nullable = false)
    public Long stnId; //역 ID

	@Id
    @Column(nullable = false, length = 8)
    public String date; //측정날짜

	@Id
    @Column(nullable = false, length = 2)
    public Integer time; //측정시간대 (4: 04시 - 05시)

    public Integer count; //인구유동량(명)

	class PK implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6628201877629932150L;
		public Long stnId;
		public String date;
		public Integer time;
	}
}
