import entities.Employee;

void main() {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("How many employees will be registered? ");
    int n = sc.nextInt();

    List<Employee> employees = new ArrayList<>();

    for (int i = 0; i < n; i++){
        System.out.printf("Employee #%d", i + 1);
        System.out.println();

        System.out.print("Id: ");
        int id = sc.nextInt();

        System.out.print("Name: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Salary: ");
        double salary = sc.nextDouble();

        System.out.println();

        employees.add(new Employee(id, name, salary));
    }


    System.out.print("Enter the employee id that will have salary increase: ");
    int employeeId = sc.nextInt();

    Employee employeeFiltered = employees.stream().filter(emp -> emp.getId() == employeeId).findFirst().orElse(null);

    if (employeeFiltered != null) {
        System.out.print("Enter the percentage: ");
        double increasePercentage = sc.nextDouble();

        employeeFiltered.increaseSalary(increasePercentage);
        System.out.println();
    } else {
        System.out.println("===============");
        System.out.println("This id does not exist!");
        System.out.println("===============");
    }

    System.out.println("List of employees:");
    for (Employee emp : employees) {
        System.out.printf("%d, %s, %.2f", emp.getId(), emp.getName(), emp.getSalary());
        System.out.println();
    }

    System.out.println();

    sc.close();
}