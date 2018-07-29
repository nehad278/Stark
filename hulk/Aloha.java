

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static class ComponentInfo{
        public String[] dependencies;
        public Boolean installed;
        public Integer installInfo; // explicit = 1, implicit = -1
        public Integer index;
        public ComponentInfo(){
            this.installed = false;
            this.installInfo = 0;
            this.dependencies = new String[0];
            this.index = 0;
        }
        public ComponentInfo(String[] dependencies, Boolean installed, Integer installInfo, Integer index){
            this.dependencies = dependencies;
            this.installed = installed;
            this.installInfo = installInfo;
            this.index = index;
        }
        
        public void setInstalled(Boolean installed){
            this.installed = installed;
        }
        
        public void setDependencies(String[] dependencies){
            this.dependencies = dependencies;
        }
        
        public void setInstallInfo(Integer installInfo){
            this.installInfo = installInfo;
        }
        public void setIndex(Integer index){
            this.index = index;
        }
    }
    
    public static Integer componentNo = 1;
    public static HashMap<String, ComponentInfo> componentMap = new HashMap<String, ComponentInfo>();
    
/*
 * Complete the function below.
 */

    static void doIt(String[] input) {
        for(String l: input){
            System.out.println(l);
            String[] command = l.trim().split(" ");
            switch(command[0]) {
                case "DEPEND":
                    depend(command);
                    break;
                case "INSTALL": 
                    install(command);
                    break;
                case "REMOVE": 
                    remove(command);
                    break;
                case "LIST": 
                    list();
                    break;
                case "END": 
                    break;
            }
        }
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }
        
        doIt(_input);
        
    }
    
    private static void depend(String[] command){
        Integer commandLength = command.length;
        String component = command[1];
        String[] dependencies = new String[commandLength - 2];
        for(int i =0; i < commandLength -2; i++){
            dependencies[i] = command[i + 2];
        }
        
        // Check whether dependency is valid
        for (String dependency: dependencies){
            if(componentMap.containsKey(dependency) && Arrays.asList(componentMap.get(dependency).dependencies).contains(component)){
                System.out.println(dependency + " depends on " + component + ", ignoring command");
                return;
            }
        }
        
        //put dependencies for component
        componentMap.put(component, new ComponentInfo(dependencies, false, 0, 0));
        
        // put all dependencies in map
        for (String dependency: dependencies){
            componentMap.put(dependency, new ComponentInfo());
        } 
    }
    
    public static void install(String[] command){
        // if already installed
        if (componentMap.containsKey(command[1]) && componentMap.get(command[1]).installed){
            System.out.println(command[1] + " is already installed");
        }
        
        // install
        installComponent(command[1], 1);
        
    }
    
     public static void remove(String[] command){
         String removalComponent = command[1];
         removeComponent(removalComponent, true);
    }
    
    public static void list(){
        Set<String> components = componentMap.keySet();
        HashMap<Integer, String> componentIndexMap = new HashMap<Integer, String>(); 
        for (String component: components){
            if (componentMap.get(component).installed){
                componentIndexMap.put(componentMap.get(component).index, component);
            }
        }
        Set<Integer> indexes = componentIndexMap.keySet();
        List<Integer> indexList = new ArrayList<Integer>(indexes);
        Collections.sort(indexList);
        
        for (Integer index: indexList){
            System.out.println(componentIndexMap.get(index));
        }
        
    }
    
    //helper function
    private static void installComponent(String component, Integer explicitFlag){
        if (componentMap.containsKey(component)){
            String[] dependencies = componentMap.get(component).dependencies;
            for (String dependency: dependencies){
                if(!componentMap.get(dependency).installed){
                    installComponent(dependency, -1);
                }
            }
        }
        if (componentMap.containsKey(component)){
            String[] d = componentMap.get(component).dependencies;
            componentMap.put(component, new ComponentInfo(d, true, explicitFlag, componentNo));
        } else {
            componentMap.put(component, new ComponentInfo(new String[0], true, explicitFlag, componentNo));
        }
        componentNo ++;
        System.out.println("Installing " + component);
    }
    
    private static void removeComponent(String removalComponent, Boolean dependencyCheck){
        // Should not be a dependency, (Still neeed)
        Set<String> components = componentMap.keySet();
        for (String component: components){
            if (Arrays.asList(componentMap.get(component).dependencies).contains(removalComponent)){
                if (dependencyCheck){
                    System.out.println(removalComponent + " is still needed");
                }
                return;
            }
        }
             
        String[] dependencies = componentMap.get(removalComponent).dependencies;
        componentMap.put(removalComponent, new ComponentInfo(dependencies, false, 0, 0));
        System.out.println("Removing " + removalComponent);
        for (String component: dependencies){
            removeComponent(component, false);
        }
    }
}
