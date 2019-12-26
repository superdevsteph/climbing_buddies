package fr.ocr.climbing.dao;

import java.util.List;

import fr.ocr.climbing.entity.Topo;
import fr.ocr.climbing.model.TopoInfo;

public interface TopoDAO {

	public Topo findTopo(Long id);

	public List<TopoInfo> listTopoInfos();

	public void saveTopo(TopoInfo topoInfo);

	public TopoInfo findTopoInfo(Long id);

	public void deleteTopo(Long id);

}