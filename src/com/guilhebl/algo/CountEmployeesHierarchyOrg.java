package com.guilhebl.algo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
Given a dictionary that contains mapping of employee and his/her manager like this

      Dictionary<string, string> employees = new Dictionary<>()
            {
                { "A","C" },
                { "B","C" },
                { "C","F" },
                { "D","E" },
                { "E","F" },
                { "F","F" }
            };

Write a function to get no of employees under each manager in the hierarchy not just their direct reports.
In the above dictionary the root node/ceo is listed as reporting to himself.

Output should be a Dictionary<string,int> that contains this:

    A - 0
    B - 0
    C - 2
    D - 0
    E - 1
    F - 5
 * 
 */
public class CountEmployeesHierarchyOrg {

	public static void main(String[] args) {
		printAllEmployeesOfAllManagers();		
	}
	

	public static void printAllEmployeesOfAllManagers() {
		Map<String, String> dataSet = new HashMap<>();
		dataSet.put("A", "C");
		dataSet.put("B", "C");
		dataSet.put("C", "F");
		dataSet.put("D", "E");
		dataSet.put("E", "F");
		dataSet.put("F", "F");

		Map<String, TreeNodeEmp> empTreeNodeMap = new HashMap<>();
		TreeNodeEmp root = buildHierarchyTreeOfCompany(dataSet, empTreeNodeMap);
		Map<String, Integer> output = new HashMap<>();

		for (Map.Entry<String, TreeNodeEmp> empEntry : empTreeNodeMap
				.entrySet()) {
			String empName = empEntry.getKey();
			TreeNodeEmp emp = empEntry.getValue();
			output.put(empName, getCountEmployeesOfManager(emp) - 1);
		}
		printResults(output);
	}

	public static void printResults(Map<String, Integer> results) {
		for (Map.Entry<String, Integer> r : results.entrySet()) {
			System.out.println(r.getKey() + " - " + r.getValue());
		}
	}

	public static Integer getCountEmployeesOfManager(TreeNodeEmp root) {
		int count = 1;
		for (TreeNodeEmp emp : root.children) {
			count += getCountEmployeesOfManager(emp);
		}
		return count;
	}

	public static TreeNodeEmp buildHierarchyTreeOfCompany(
			Map<String, String> empMap, Map<String, TreeNodeEmp> empTreeNodeMap) {
		Map<String, List<TreeNodeEmp>> auxMgrEmpList = new HashMap<>();
		List<TreeNodeEmp> listEmps = null;
		TreeNodeEmp emp = null, mgr = null, root = null;
		String nameEmp, managerName;

		for (Map.Entry<String, String> empMapEntry : empMap.entrySet()) {
				nameEmp = empMapEntry.getKey();
				managerName = empMapEntry.getValue();

				if (!empTreeNodeMap.containsKey(nameEmp)) {
					emp = new TreeNodeEmp(nameEmp, managerName);

					// check for who was added before and have this as a manger
					if(auxMgrEmpList.containsKey(nameEmp)) {
					   emp.children.addAll(auxMgrEmpList.get(nameEmp));	
					}										
					empTreeNodeMap.put(nameEmp, emp);
				}
				
				if (nameEmp.equals(managerName)) {
					root = emp;
				} else if (empTreeNodeMap.containsKey(managerName)) {
					mgr = empTreeNodeMap.get(managerName);
					mgr.children.add(emp);
				} else if (!auxMgrEmpList.containsKey(managerName)){
					listEmps = new ArrayList<>();
					listEmps.add(emp);
					auxMgrEmpList.put(managerName, listEmps);
				} else {
					listEmps = auxMgrEmpList.get(managerName);
					listEmps.add(emp);
					auxMgrEmpList.put(managerName, listEmps);					
				}

		}

		return root;
	}
}

class TreeNodeEmp {
	String name;
	String managerName;
	Set<TreeNodeEmp> children;

	public TreeNodeEmp(String name, String managerName) {
		this.name = name;
		this.managerName = managerName;
		children = new HashSet<>();
	}

}