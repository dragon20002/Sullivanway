package blacksmith.sullivanwayserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Station implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2419613410154351119L;

	@Id
    public Long id;
    
    @Column(name = "line_id")
    public Long lineId; //호선 ID
    
    @Column(name = "node_id")
    public Long nodeId; //역 노드 ID
}
