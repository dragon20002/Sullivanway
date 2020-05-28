package blacksmith.sullivanwayserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import blacksmith.sullivanwayserver.model.SearchHistory.PK;

@Entity(name = "search_history")
@IdClass(PK.class)
public class SearchHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4101561626514959088L;

	@Id
    @Column(name = "start_node_id", nullable = false)
    public Long startNodeId; //출발역 노드 ID

	@Id
    @Column(name = "end_node_id", nullable = false)
    public Long endNodeId; //도착역 노드 ID

    public Integer type; //기록유형 (1: History, 2: Favorite)
    
    @Column(name = "req_timestamp")
    public Long regTimestamp; //등록 시간 (millisecond)
    
    class PK implements Serializable {
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1338761230947812144L;
		public Long startNodeId;
    	public Long endNodeId;
    }
}
