#include<stdio.h>
#include<stdlib.h>

struct node{
    int data;
    struct node *next ;
};
struct node* create_node(struct node *head);
struct node* create_new_list(struct node *head);
struct node * insert_node(struct node *head);
struct node * delete_node(struct node *head);
struct node * reverse_list(struct node *head);
int display(struct node *head);
int length(struct node *head);
int main()
{
    int length,n;
    struct node *head;
    head = (struct node *)malloc(sizeof(struct node));

    printf("Enter the following codes for the respective operations :\n1 - create new list\n2 - insert node\n3 - delete node\n4 - reverse list \n5 - display list \n 0 - exit\n\n");
    printf("Enter the code :");
    scanf("%d",&n);

    while (n>0)
    {
        switch (n)
        {
            case 1 : head = create_new_list(head);break;
            case 2 : head = insert_node(head); break;
            case 3 : head = delete_node(head); break;
            case 4 : head = reverse_list(head); break;
            case 5 : length = display(head);break;
            default : printf("enter the correct code");break;
        }
        printf("\n\nEnter the code :");
        scanf("%d",&n);
    }
    return 0;
}

struct node* create_new_list(struct node *head)
{
    int n,d;
    printf("Enter the number of elements :");
    scanf("%d",&n);
    printf("Enter the element :");
    scanf("%d",&d);
    head->data = d;
    head->next = NULL;
    for(int i=1;i<n;i++)
    {
        head = create_node(head);
    }
    return head;
}

struct node * create_node(struct node *head)
{
    int d;
    printf("enter the element :");
    scanf("%d",&d);
    struct node *ptr;
    ptr = head;
    while(ptr->next!=NULL)
    {
        ptr = ptr->next;
    }
    struct node *new;
    new = (struct node*)malloc(sizeof(struct node));

    new->data = d;
    ptr->next = new;
    new->next = NULL;
    // d = display(head);
    return head;
}

int display(struct node *head)
{
    int i=0;
    while(head!=NULL)
    {
        printf("element %d : %d\n",i,head->data);
        head = head->next;
        i++;
    }
    printf("Length of the linked list = %d ",i);
    return i;

}
int length(struct node *head)
{
    int i=0;
    while(head!=NULL)
    {
        head = head->next;
        i++;
    }
    return i;
}

struct node * insert_node(struct node *head)
{
    int ind,element;
    int len = length(head);
    printf("Enter the index :");
    scanf("%d",&ind);
    ;
    if (ind == 0)
    {
    struct node *new;
    new = (struct node*)malloc(sizeof(struct node));
    printf("Enter the element :");
    scanf("%d",&element);
    new->data = element;
    new->next = head;
    head = new;
    }
    else if (ind == len )
    {
        head = create_node(head);
    }
    else
    {
        printf("Enter the element :");
        scanf("%d",&element);
        struct node *temp;
        temp = head;
        for(int i=0;i<=ind;i++)
        {
            temp = temp->next;
        }
    
    struct node *new;
    new = (struct node*)malloc(sizeof(struct node));
    new->data = element;
    new->next = temp->next;
    temp->next = new;
    }
    return head;
}
struct node * delete_node(struct node *head)
{
    int ind,l;
    l = length(head);
    
    printf("Enter the index :");
    scanf("%d",&ind);
    struct node *ptr1,*ptr2;
    ptr1 = (struct node*)malloc(sizeof(struct node));
    ptr1 = head;
    ptr2 = (struct node*)malloc(sizeof(struct node));
    ptr2 = ptr1->next;
    if(ind == 0)
    {
    
        free(head);
        return ptr2;
    }
    
    else if(ind == l-1 )
    {
    
        while(ptr2->next != NULL)
            {
                ptr1=ptr1->next;
                ptr2=ptr2->next;
            }
        ptr1->next = NULL;
        free(ptr2);
        return head;
    }
    
    else
    {
    
        for(int i=0;i<ind-1;i++)
        {
            ptr1=ptr1->next;
            ptr2=ptr2->next;
        }
        ptr1->next = ptr2->next;
        free(ptr2);
    
        return head;
    }
    printf("LIST OUT OF INDEX");
}

struct node * reverse_list(struct node *head)
{
    struct node *prev_node,*current_node,*next_node;
    prev_node = NULL;
    current_node = next_node = head;
    while(next_node!=NULL)
    {
        next_node = next_node->next;
        current_node->next = prev_node;
        prev_node = current_node;
        current_node = next_node;
    }
    head = prev_node;
    return head;
}
